/* ----------------------------------------------------------------------------
 * This file was automatically generated by SWIG (http://www.swig.org).
 * Version 1.3.37
 *
 * Do not make changes to this file unless you know what you are doing--modify
 * the SWIG interface file instead.
 * ----------------------------------------------------------------------------- */

package com.xuggle.xuggler;
import com.xuggle.ferry.*;
/**
 * A set of raw (decoded) samples, plus a timestamp for when to play 
 * those  
 * samples relative to other items in a given {@link IContainer}.  
 * The timestamp value in decoded data is always in Microseonds.  
 */
public class IAudioSamples extends IMediaData {
  // JNIHelper.swg: Start generated code
  // >>>>>>>>>>>>>>>>>>>>>>>>>>>
  /**
   * This method is only here to use some references and remove
   * a Eclipse compiler warning.
   */
  @SuppressWarnings("unused")
  private void noop()
  {
    IBuffer.make(null, 1);
  }
   
  private volatile long swigCPtr;

  /**
   * Internal Only.
   */
  protected IAudioSamples(long cPtr, boolean cMemoryOwn) {
    super(XugglerJNI.SWIGIAudioSamplesUpcast(cPtr), cMemoryOwn);
    swigCPtr = cPtr;
  }
  
  /**
   * Internal Only.  Not part of public API.
   *
   * Get the raw value of the native object that obj is proxying for.
   *   
   * @param obj The java proxy object for a native object.
   * @return The raw pointer obj is proxying for.
   */
  public static long getCPtr(IAudioSamples obj) {
    if (obj == null) return 0;
    return obj.getMyCPtr();
  }

  /**
   * Internal Only.  Not part of public API.
   *
   * Get the raw value of the native object that we're proxying for.
   *   
   * @return The raw pointer we're proxying for.
   */  
  public long getMyCPtr() {
    if (swigCPtr == 0) throw new IllegalStateException("underlying native object already deleted");
    return swigCPtr;
  }
  
  /**
   * Create a new IAudioSamples object that is actually referring to the
   * exact same underlying native object.
   *
   * This method increases the ref count of the underlying Native object.
   *
   * @return the new Java object.
   */
  public IAudioSamples copyReference() {
    if (swigCPtr == 0)
      return null;
    else
    {
      // acquire before making copy to avoid memory allocator being
      // overridden
      IAudioSamples retval = null;
      this.acquire();
      try {
         retval = new IAudioSamples(swigCPtr, false);
      } catch (Throwable t) {
        this.release();
        throw new RuntimeException(t);
      }
      return retval;
    }
  }

  /**
   * Releases ths instance of IAudioSamples and frees any underlying
   * native memory.
   * <p>
   * {@inheritDoc}
   * </p> 
   */
  public void delete()
  {
    do {} while(false); // remove a warning
    super.delete();
  }

  /**
   * Compares two values, returning true if the underlying objects in native code are the same object.
   *
   * That means you can have two different Java objects, but when you do a comparison, you'll find out
   * they are the EXACT same object.
   *
   * @return True if the underlying native object is the same.  False otherwise.
   */
  public boolean equals(Object obj) {
    boolean equal = false;
    if (obj instanceof IAudioSamples)
      equal = (((IAudioSamples)obj).swigCPtr == this.swigCPtr);
    return equal;
  }
  
  /**
   * Get a hashable value for this object.
   *
   * @return the hashable value.
   */
  public int hashCode() {
     return (int)swigCPtr;
  }
  
  // <<<<<<<<<<<<<<<<<<<<<<<<<<<
  // JNIHelper.swg: End generated code
  

  /**
   * info about this packet
   * @return information about this packet
   */
   
  @Override
  public String toString()
  {
    StringBuilder result = new StringBuilder();
    
    result.append(this.getClass().getName()+"@"+hashCode()+"[");
    result.append("sample rate:"+getSampleRate()+";");
    result.append("channels:"+getChannels()+";");
    result.append("format:"+getFormat()+";");
    result.append("time stamp:"+getTimeStamp()+";");
    result.append("complete:"+isComplete()+";");
    result.append("num samples:"+getNumSamples()+";");
    result.append("size:"+getSize()+";");
    result.append("key:"+isKey()+";");
    IRational timeBase = IRational.make(1,(int)Global.DEFAULT_PTS_PER_SECOND);
    result.append("time base:"+timeBase+";");
    if (timeBase != null) timeBase.delete();
    result.append("]");
    return result.toString();
  }


/**
 * Returns whether or not we think this buffer has been filled  
 * with data.  
 *  
 */
  public boolean isComplete() {
    return XugglerJNI.IAudioSamples_isComplete(swigCPtr, this);
  }

/**
 * Find the sample rate of the samples in this audio buffer.  
 * @return	The Sampling Rate of the samples in this buffer (e.g. 22050). 
 *		  
 */
  public int getSampleRate() {
    return XugglerJNI.IAudioSamples_getSampleRate(swigCPtr, this);
  }

/**
 * Return the number of channels of the samples in this buffer. For 
 * example,  
 * 1 is mono, 2 is stereo.  
 * @return	The number of channels.  
 */
  public int getChannels() {
    return XugglerJNI.IAudioSamples_getChannels(swigCPtr, this);
  }

/**
 * Find out the bit-depth of the samples in this buffer.  
 * @return	Number of bits in a raw sample (per channel)  
 */
  public long getSampleBitDepth() {
    return XugglerJNI.IAudioSamples_getSampleBitDepth(swigCPtr, this);
  }

/**
 * Find the Format of the samples in this buffer. Right now  
 * only FMT_S16 is supported.  
 * @return	The format of the samples.  
 */
  public IAudioSamples.Format getFormat() {
    return IAudioSamples.Format.swigToEnum(XugglerJNI.IAudioSamples_getFormat(swigCPtr, this));
  }

/**
 * Get the number of samples in this video.  
 *  
 * audio in this buffer, there are 25 samples. If you have  
 * 100 bytes of mono (1-channel) 16-bit audio in this buffer, you  
 * have 50 samples.  
 * @return	The number of samples.  
 */
  public long getNumSamples() {
    return XugglerJNI.IAudioSamples_getNumSamples(swigCPtr, this);
  }

/**
 * @return	Maximum number of bytes that can be put in  
 * this buffer. To get the number of samples you can  
 * put in this IAudioSamples instance, do the following  
 * num_samples = getMaxBufferSize() (getSampleSize())  
 */
  public long getMaxBufferSize() {
    return XugglerJNI.IAudioSamples_getMaxBufferSize(swigCPtr, this);
  }

/**
 * @return	Maximum number of samples this buffer can hold.  
 */
  public long getMaxSamples() {
    return XugglerJNI.IAudioSamples_getMaxSamples(swigCPtr, this);
  }

/**
 * @return	Number of bytes in a single sample of audio (including channels). 
 *		  
 * You can also get this by getSampleBitDepth()*getChannels()/8.  
 */
  public long getSampleSize() {
    return XugglerJNI.IAudioSamples_getSampleSize(swigCPtr, this);
  }

/**
 * What is the Presentation Time Stamp of this set of audio samples. 
 *  
 * @return	the presentation time stamp (pts)  
 */
  public long getPts() {
    return XugglerJNI.IAudioSamples_getPts(swigCPtr, this);
  }

/**
 * Set the Presentation Time Stamp for this set of samples.  
 * @param	aValue the new value  
 */
  public void setPts(long aValue) {
    XugglerJNI.IAudioSamples_setPts(swigCPtr, this, aValue);
  }

/**
 * What would be the next Presentation Time Stamp after all the  
 * samples in this buffer were played?  
 * @return	the next presentation time stamp (pts)  
 */
  public long getNextPts() {
    return XugglerJNI.IAudioSamples_getNextPts(swigCPtr, this);
  }

/**
 * Call this if you modify the samples and are now done. This  
 * updates the pertinent information in the structure.  
 * @param	complete Is this set of samples complete?  
 * @param	numSamples Number of samples in this update (note that  
 * 4 shorts of 16-bit audio in stereo is actually 1 sample).  
 * @param	sampleRate The sample rate (in Hz) of this set of samples. 
 *		  
 * @param	channels The number of channels in this set of samples.  
 * @param	format The sample-format of this set of samples.  
 * @param	pts The presentation time stamp of the starting sample in 
 *		 this buffer.  
 * Caller must ensure pts is in units of 1/1,000,000 of a second  
 */
  public void setComplete(boolean complete, long numSamples, int sampleRate, int channels, IAudioSamples.Format format, long pts) {
    XugglerJNI.IAudioSamples_setComplete(swigCPtr, this, complete, numSamples, sampleRate, channels, format.swigValue(), pts);
  }

/**
 * Sets the sample at the given index and channel to the sample. In 
 *  
 * theory we assume input is the given Format, and will convert  
 * if needed, but right now we only support FMT_S16 anyway.  
 *  
 * @param	channel The zero-based channel number. If this set of samples 
 *		 doesn't  
 * have that given channel, an error is returned.  
 * @param	format The format of the given sample  
 * @param	sample The actual sample  
 * @return	>= 0 on success; -1 on error.  
 */
  public int setSample(long sampleIndex, int channel, IAudioSamples.Format format, int sample) {
    return XugglerJNI.IAudioSamples_setSample(swigCPtr, this, sampleIndex, channel, format.swigValue(), sample);
  }

/**
 * Get the sample at the given sampleIndex and channel, and return it 
 * in  
 * the asked for format.  
 * @param	sampleIndex The zero-based index into this set of samples. 
 *		  
 * @param	channel The zero-based channel to get the sample from  
 * @param	format The format to return in  
 * @return	The sample if available. If that sample is not available 
 *		  
 * (e.g. because the channel doesn't exist, or the samples have not 
 *  
 * been #setComplete(bool, uint32_t, int32_t, int32_t, Format, int64_t)), 
 *  
 * then this method returns 0. It is up to the caller to ensure  
 *  
 */
  public int getSample(long sampleIndex, int channel, IAudioSamples.Format format) {
    return XugglerJNI.IAudioSamples_getSample(swigCPtr, this, sampleIndex, channel, format.swigValue());
  }

/**
 * A convenience method that returns the # of bits in a given  
 * format. Be aware that right now this library only supports  
 * 16-bit audio.  
 * @param	format The format you want to find the number of bits in. 
 *		  
 *  
 */
  public static long findSampleBitDepth(IAudioSamples.Format format) {
    return XugglerJNI.IAudioSamples_findSampleBitDepth(format.swigValue());
  }

/**
 * Get a new audio samples buffer.  
 * <p>  
 * Note that any buffers this objects needs will be  
 * lazily allocated (i.e. we won't actually grab all  
 * the memory until we need it).  
 * </p>  
 * @param	numSamples The minimum number of samples you're  
 * going to want to put in this buffer. We may (and probably  
 * will) return a larger buffer, but you cannot assume that.  
 * @param	numChannels The number of channels in the audio you'll  
 * want to put in this buffer.  
 * @return	A new object, or null if we can't allocate one.  
 */
  public static IAudioSamples make(long numSamples, long numChannels) {
    long cPtr = XugglerJNI.IAudioSamples_make(numSamples, numChannels);
    return (cPtr == 0) ? null : new IAudioSamples(cPtr, false);
  }

/**
 * Converts a number of samples at a given sampleRate into  
 * Microseconds.  
 * @param	samples Number of samples.  
 * @param	sampleRate sample rate that those samples are recorded at. 
 *		  
 * @return	number of microseconds it would take to play that audio. 
 *		  
 */
  public static long samplesToDefaultPts(long samples, int sampleRate) {
    return XugglerJNI.IAudioSamples_samplesToDefaultPts(samples, sampleRate);
  }

/**
 * Converts a duration in microseconds into  
 * a number of samples, assuming a given sampleRate.  
 * @param	duration The duration in microseconds.  
 * @param	sampleRate sample rate that you want to use.  
 * @return	The number of samples it would take (at the given sampleRate) 
 *		 to take duration microseconds to play.  
 */
  public static long defaultPtsToSamples(long duration, int sampleRate) {
    return XugglerJNI.IAudioSamples_defaultPtsToSamples(duration, sampleRate);
  }

  public enum Format {
  /**
   * The format we use to represent audio. Today
   * only FMT_S16 (signed integer 16-bit audio) is supported.
   */
    FMT_NONE(XugglerJNI.IAudioSamples_FMT_NONE_get()),
    FMT_U8,
    FMT_S16,
    FMT_S24,
    FMT_S32,
    FMT_FLT;

    public final int swigValue() {
      return swigValue;
    }

    public static Format swigToEnum(int swigValue) {
      Format[] swigValues = Format.class.getEnumConstants();
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (Format swigEnum : swigValues)
        if (swigEnum.swigValue == swigValue)
          return swigEnum;
      throw new IllegalArgumentException("No enum " + Format.class + " with value " + swigValue);
    }

    @SuppressWarnings("unused")
    private Format() {
      this.swigValue = SwigNext.next++;
    }

    @SuppressWarnings("unused")
    private Format(int swigValue) {
      this.swigValue = swigValue;
      SwigNext.next = swigValue+1;
    }

    @SuppressWarnings("unused")
    private Format(Format swigEnum) {
      this.swigValue = swigEnum.swigValue;
      SwigNext.next = this.swigValue+1;
    }

    private final int swigValue;

    private static class SwigNext {
      private static int next = 0;
    }
  }

  public enum ChannelLayout {
    CH_FRONT_LEFT(XugglerJNI.IAudioSamples_CH_FRONT_LEFT_get()),
    CH_FRONT_RIGHT(XugglerJNI.IAudioSamples_CH_FRONT_RIGHT_get()),
    CH_FRONT_CENTER(XugglerJNI.IAudioSamples_CH_FRONT_CENTER_get()),
    CH_LOW_FREQUENCY(XugglerJNI.IAudioSamples_CH_LOW_FREQUENCY_get()),
    CH_BACK_LEFT(XugglerJNI.IAudioSamples_CH_BACK_LEFT_get()),
    CH_BACK_RIGHT(XugglerJNI.IAudioSamples_CH_BACK_RIGHT_get()),
    CH_FRONT_LEFT_OF_CENTER(XugglerJNI.IAudioSamples_CH_FRONT_LEFT_OF_CENTER_get()),
    CH_FRONT_RIGHT_OF_CENTER(XugglerJNI.IAudioSamples_CH_FRONT_RIGHT_OF_CENTER_get()),
    CH_BACK_CENTER(XugglerJNI.IAudioSamples_CH_BACK_CENTER_get()),
    CH_SIDE_LEFT(XugglerJNI.IAudioSamples_CH_SIDE_LEFT_get()),
    CH_SIDE_RIGHT(XugglerJNI.IAudioSamples_CH_SIDE_RIGHT_get()),
    CH_TOP_CENTER(XugglerJNI.IAudioSamples_CH_TOP_CENTER_get()),
    CH_TOP_FRONT_LEFT(XugglerJNI.IAudioSamples_CH_TOP_FRONT_LEFT_get()),
    CH_TOP_FRONT_CENTER(XugglerJNI.IAudioSamples_CH_TOP_FRONT_CENTER_get()),
    CH_TOP_FRONT_RIGHT(XugglerJNI.IAudioSamples_CH_TOP_FRONT_RIGHT_get()),
    CH_TOP_BACK_LEFT(XugglerJNI.IAudioSamples_CH_TOP_BACK_LEFT_get()),
    CH_TOP_BACK_CENTER(XugglerJNI.IAudioSamples_CH_TOP_BACK_CENTER_get()),
    CH_TOP_BACK_RIGHT(XugglerJNI.IAudioSamples_CH_TOP_BACK_RIGHT_get()),
    CH_STEREO_LEFT(XugglerJNI.IAudioSamples_CH_STEREO_LEFT_get()),
    CH_STEREO_RIGHT(XugglerJNI.IAudioSamples_CH_STEREO_RIGHT_get()),
    CH_LAYOUT_MONO(XugglerJNI.IAudioSamples_CH_LAYOUT_MONO_get()),
    CH_LAYOUT_STEREO(XugglerJNI.IAudioSamples_CH_LAYOUT_STEREO_get()),
    CH_LAYOUT_2_1(XugglerJNI.IAudioSamples_CH_LAYOUT_2_1_get()),
    CH_LAYOUT_SURROUND(XugglerJNI.IAudioSamples_CH_LAYOUT_SURROUND_get()),
    CH_LAYOUT_4POINT0(XugglerJNI.IAudioSamples_CH_LAYOUT_4POINT0_get()),
    CH_LAYOUT_2_2(XugglerJNI.IAudioSamples_CH_LAYOUT_2_2_get()),
    CH_LAYOUT_QUAD(XugglerJNI.IAudioSamples_CH_LAYOUT_QUAD_get()),
    CH_LAYOUT_5POINT0(XugglerJNI.IAudioSamples_CH_LAYOUT_5POINT0_get()),
    CH_LAYOUT_5POINT1(XugglerJNI.IAudioSamples_CH_LAYOUT_5POINT1_get()),
    CH_LAYOUT_5POINT0_BACK(XugglerJNI.IAudioSamples_CH_LAYOUT_5POINT0_BACK_get()),
    CH_LAYOUT_5POINT1_BACK(XugglerJNI.IAudioSamples_CH_LAYOUT_5POINT1_BACK_get()),
    CH_LAYOUT_7POINT1(XugglerJNI.IAudioSamples_CH_LAYOUT_7POINT1_get()),
    CH_LAYOUT_7POINT1_WIDE(XugglerJNI.IAudioSamples_CH_LAYOUT_7POINT1_WIDE_get()),
    CH_LAYOUT_STEREO_DOWNMIX(XugglerJNI.IAudioSamples_CH_LAYOUT_STEREO_DOWNMIX_get());

    public final int swigValue() {
      return swigValue;
    }

    public static ChannelLayout swigToEnum(int swigValue) {
      ChannelLayout[] swigValues = ChannelLayout.class.getEnumConstants();
      if (swigValue < swigValues.length && swigValue >= 0 && swigValues[swigValue].swigValue == swigValue)
        return swigValues[swigValue];
      for (ChannelLayout swigEnum : swigValues)
        if (swigEnum.swigValue == swigValue)
          return swigEnum;
      throw new IllegalArgumentException("No enum " + ChannelLayout.class + " with value " + swigValue);
    }

    @SuppressWarnings("unused")
    private ChannelLayout() {
      this.swigValue = SwigNext.next++;
    }

    @SuppressWarnings("unused")
    private ChannelLayout(int swigValue) {
      this.swigValue = swigValue;
      SwigNext.next = swigValue+1;
    }

    @SuppressWarnings("unused")
    private ChannelLayout(ChannelLayout swigEnum) {
      this.swigValue = swigEnum.swigValue;
      SwigNext.next = this.swigValue+1;
    }

    private final int swigValue;

    private static class SwigNext {
      private static int next = 0;
    }
  }

}
