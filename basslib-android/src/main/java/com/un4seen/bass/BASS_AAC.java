package com.un4seen.bass;

import java.nio.ByteBuffer;

public class BASS_AAC
{
	// additional error codes returned by BASS_ErrorGetCode
	public static final int BASS_ERROR_MP4_NOSTREAM = 6000; // non-streamable due to MP4 atom order ("mdat" before "moov")

	// Additional BASS_SetConfig options
	public static final int BASS_CONFIG_MP4_VIDEO = 0x10700; // play the audio from MP4 videos
	public static final int BASS_CONFIG_AAC_MP4 = 0x10701; // support MP4 in BASS_AAC_StreamCreateXXX functions (no need for BASS_MP4_StreamCreateXXX)
	public static final int BASS_CONFIG_AAC_PRESCAN	= 0x10702; // pre-scan ADTS AAC files for seek points and accurate length

	// Additional BASS_AAC_StreamCreateFile/etc flags
	public static final int BASS_AAC_FRAME960 = 0x1000; // 960 samples per frame
	public static final int BASS_AAC_STEREO = 0x400000; // downmatrix to stereo

	// BASS_CHANNELINFO type
	public static final int BASS_CTYPE_STREAM_AAC = 0x10b00; // AAC
	public static final int BASS_CTYPE_STREAM_MP4 = 0x10b01; // AAC in MP4

	public static native int BASS_AAC_StreamCreateFile(String file, long offset, long length, int flags);
	public static native int BASS_AAC_StreamCreateFile(ByteBuffer file, long offset, long length, int flags);
	public static native int BASS_AAC_StreamCreateURL(String url, int offset, int flags, BASS.DOWNLOADPROC proc, Object user);
	public static native int BASS_AAC_StreamCreateFileUser(int system, int flags, BASS.BASS_FILEPROCS procs, Object user);
	public static native int BASS_MP4_StreamCreateFile(String file, long offset, long length, int flags);
	public static native int BASS_MP4_StreamCreateFile(ByteBuffer file, long offset, long length, int flags);
	public static native int BASS_MP4_StreamCreateFileUser(int system, int flags, BASS.BASS_FILEPROCS procs, Object user);
	
    static {
        System.loadLibrary("bass_aac");
    }
}
