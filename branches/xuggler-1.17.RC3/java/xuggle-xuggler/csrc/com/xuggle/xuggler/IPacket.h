/*
 * Copyright (c) 2008-2009 by Xuggle Inc. All rights reserved.
 *
 * It is REQUESTED BUT NOT REQUIRED if you use this library, that you let 
 * us know by sending e-mail to info@xuggle.com telling us briefly how you're
 * using the library and what you like or don't like about it.
 *
 * This library is free software; you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free Software
 * Foundation; either version 2.1 of the License, or (at your option) any later
 * version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along
 * with this library; if not, write to the Free Software Foundation, Inc.,
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 */
#ifndef IPACKET_H_
#define IPACKET_H_

#include <com/xuggle/xuggler/Xuggler.h>
#include <com/xuggle/xuggler/IMediaData.h>
namespace com { namespace xuggle { namespace xuggler
{

  /**
   * Represents an encoded piece of data that can be placed in an {@link IContainer}
   * for a given {@link IStream} of data.
   * <p>
   * You read this object out of {@link IContainer} objects when decoding, and
   * pass to an {@link IStreamCoder} object to decode.
   * </p><p>
   * You pass this object to a {@link IStreamCoder} to encode data, and then
   * pass to an {@link IContainer} object to write to a data source.
   * </p><p>
   * Lastly, the units of timestamps in an {@link IPacket} are determined by the
   * {@link IContainer} it came from (or is going to).  For example, FLV {@link IPacket}s
   * are always in milliseconds (1/1000 of a second).  You cannot assume these
   * timestamps are in any given timeunit without getting an {@link IStream} object
   * and finding out what Time Base that stream operates in.
   * </p><p>
   * For convenience, the Xuggler API always uses Microseconds for raw data
   * ({@link IVideoPicture} and {@link IAudioSamples} objects), and will convert to
   * the right time stamp unit when decoding or encoding data (with an {@link IStreamCoder})
   * from or to an {@link IContainer}. 
   */
  class VS_API_XUGGLER IPacket : public IMediaData
  {
  public:
    /**
     * Clear out any data in this packet, but leaves
     * the buffer available for reuse.
     */
    virtual void reset()=0;

    /**
     * @return Is this packet full and therefore has valid information.
     */
    virtual bool isComplete()=0;

    /**
     * @return Get the Presentation Timestamp for this packet.
     */
    virtual int64_t getPts()=0;
    
    /**
     * @param aPts a new PTS for this packet.
     */
    virtual void setPts(int64_t aPts)=0;
    
    /**
     * @return Get the Decompression Timestamp (i.e. when this was read relative
     * to the start of reading packets).
     */
    virtual int64_t getDts()=0;

    /**
     * @param aDts a new DTS for this packet.
     */
    virtual void setDts(int64_t aDts)=0;
    
    /**
     * @return Size (in bytes) of payload currently in packet.
     */
    virtual int32_t getSize()=0;
    
    /**
     * @return Get maximum size (in bytes) of payload this packet can hold.
     */
    virtual int32_t getMaxSize()=0;
    
    /**
     * @return Stream in container that this packet has data for.
     */
    virtual int32_t getStreamIndex()=0;
    
    /**
     * @return Any flags on the packet.  This is access to raw FFMPEG
     * flags, but better to use the is* methods below.
     */
    virtual int32_t getFlags()=0;
    
    /**
     * @return Does this packet contain Key data (i.e. data that needs no other
     * frames or samples to decode).
     */
    virtual bool isKeyPacket()=0;
    
    /**
     * @return Duration of this packet, in same time-base as the PTS.
     */
    virtual int64_t getDuration()=0;
    
    /**
     * @return The position of this packet in the stream.
     */
    virtual int64_t getPosition()=0;
    
    /**
     * @return The raw data in this packet.  The buffer size may be larger
     * than IPacket::getSize(), but only the bytes up to getSize()
     * are valid.
     */
    virtual com::xuggle::ferry::IBuffer *getData()=0;

    /**
     * Discard the current payload and allocate a new payload.
     * 
     * Note that if any people have access to the old payload using
     * getData(), the memory will continue to be available to them
     * until they release their hold of the IBuffer.
     * 
     * @param payloadSize The (minimum) payloadSize of this packet.  The system
     *   may allocate a larger payloadSize.
     * 
     * @return >= 0 if successful.  < 0 if error.
     */
    virtual int32_t allocateNewPayload(int32_t payloadSize)=0;

    /**
     * Allocate a new packet.
     * <p>
     * Note that any buffers this packet needs will be
     * lazily allocated (i.e. we won't actually grab all
     * the memory until we need it).
     * </p>
     * 
     * @return a new packet, or null on error.
     */
    static IPacket* make();
    
    /**
     * Allocate a new packet that wraps an existing IBuffer.
     * 
     * @param buffer The IBuffer to wrap.
     * @return a new packet or null on error.
     */
    static IPacket* make(com::xuggle::ferry::IBuffer* buffer);
    
  protected:
    IPacket();
    virtual ~IPacket();
  };

}}}

#endif /*IPACKET_H_*/