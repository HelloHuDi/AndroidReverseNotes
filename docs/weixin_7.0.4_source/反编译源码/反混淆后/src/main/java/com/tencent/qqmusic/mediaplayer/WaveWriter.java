package com.tencent.qqmusic.mediaplayer;

import com.google.android.gms.wearable.WearableStatusCodes;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.qqmusic.mediaplayer.util.Logger;
import com.tencent.ugc.TXRecordCommon;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class WaveWriter {
    private static final int OUTPUT_STREAM_BUFFER = 16384;
    private static final String TAG = "WaveWriter";
    private int mBytesWritten = 0;
    private int mChannels;
    private File mOutFile;
    private BufferedOutputStream mOutStream;
    private int mSampleBits;
    private int mSampleRate;
    private ByteArrayOutputStream mTmpStream;

    public WaveWriter(String str, String str2, int i, int i2, int i3) {
        AppMethodBeat.m2504i(104700);
        this.mOutFile = new File(str + File.separator + str2);
        this.mSampleRate = i;
        this.mChannels = i2;
        this.mSampleBits = i3;
        AppMethodBeat.m2505o(104700);
    }

    public WaveWriter(File file, int i, int i2, int i3) {
        this.mOutFile = file;
        this.mSampleRate = i;
        this.mChannels = i2;
        this.mSampleBits = i3;
    }

    private static void writeUnsignedShortLE(ByteArrayOutputStream byteArrayOutputStream, short s) {
        AppMethodBeat.m2504i(104701);
        byteArrayOutputStream.write(s);
        byteArrayOutputStream.write(s >> 8);
        AppMethodBeat.m2505o(104701);
    }

    public void setSampleByte(int i) {
        this.mSampleBits = i;
    }

    public boolean createWaveFile() {
        AppMethodBeat.m2504i(104702);
        if (this.mOutFile.exists()) {
            this.mOutFile.delete();
        }
        this.mOutFile.getParentFile().mkdirs();
        if (this.mOutFile.createNewFile()) {
            this.mOutStream = new BufferedOutputStream(new FileOutputStream(this.mOutFile), OUTPUT_STREAM_BUFFER);
            this.mTmpStream = new ByteArrayOutputStream();
            this.mOutStream.write(new byte[44]);
            AppMethodBeat.m2505o(104702);
            return true;
        }
        AppMethodBeat.m2505o(104702);
        return false;
    }

    public void write(short[] sArr, int i, int i2) {
        AppMethodBeat.m2504i(104703);
        if (i > i2) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(String.format("offset %d is greater than length %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            AppMethodBeat.m2505o(104703);
            throw indexOutOfBoundsException;
        }
        while (i < i2) {
            writeUnsignedShortLE(this.mTmpStream, sArr[i]);
            this.mBytesWritten += 2;
            i++;
        }
        AppMethodBeat.m2505o(104703);
    }

    public void write(short[] sArr, short[] sArr2, int i, int i2) {
        AppMethodBeat.m2504i(104704);
        if (this.mChannels != 2) {
            AppMethodBeat.m2505o(104704);
        } else if (i > i2) {
            IndexOutOfBoundsException indexOutOfBoundsException = new IndexOutOfBoundsException(String.format("offset %d is greater than length %d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2)}));
            AppMethodBeat.m2505o(104704);
            throw indexOutOfBoundsException;
        } else {
            while (i < i2) {
                writeUnsignedShortLE(this.mTmpStream, sArr[i]);
                writeUnsignedShortLE(this.mTmpStream, sArr2[i]);
                this.mBytesWritten += 4;
                i++;
            }
            AppMethodBeat.m2505o(104704);
        }
    }

    public void closeWaveFile() {
        AppMethodBeat.m2504i(104705);
        if (this.mOutStream != null) {
            this.mOutStream.flush();
            this.mOutStream.close();
        }
        if (this.mTmpStream != null) {
            this.mTmpStream.flush();
            this.mTmpStream.close();
        }
        writeWaveHeader();
        AppMethodBeat.m2505o(104705);
    }

    private void writeWaveHeader() {
        AppMethodBeat.m2504i(104706);
        RandomAccessFile randomAccessFile = new RandomAccessFile(this.mOutFile, "rw");
        randomAccessFile.seek(0);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        int i = (this.mSampleBits + 7) / 8;
        try {
            dataOutputStream.writeBytes("RIFF");
            dataOutputStream.writeInt(Integer.reverseBytes(this.mBytesWritten + 36));
            dataOutputStream.writeBytes("WAVE");
            dataOutputStream.writeBytes("fmt ");
            dataOutputStream.writeInt(Integer.reverseBytes(16));
            dataOutputStream.writeShort(Short.reverseBytes((short) 1));
            dataOutputStream.writeShort(Short.reverseBytes((short) this.mChannels));
            dataOutputStream.writeInt(Integer.reverseBytes(this.mSampleRate));
            dataOutputStream.writeInt(Integer.reverseBytes((this.mSampleRate * this.mChannels) * i));
            dataOutputStream.writeShort(Short.reverseBytes((short) (i * this.mChannels)));
            dataOutputStream.writeShort(Short.reverseBytes((short) this.mSampleBits));
            dataOutputStream.writeBytes("data");
            dataOutputStream.writeInt(Integer.reverseBytes(this.mBytesWritten));
            byteArrayOutputStream.flush();
            randomAccessFile.write(byteArrayOutputStream.toByteArray());
        } finally {
            byteArrayOutputStream.close();
            dataOutputStream.close();
            randomAccessFile.close();
            AppMethodBeat.m2505o(104706);
        }
    }

    public int getChannels() {
        return this.mChannels;
    }

    public byte[] changeStereoToMono(byte[] bArr) {
        if (this.mChannels != 2) {
            return bArr;
        }
        int i = this.mSampleBits / 8;
        long length = (long) ((bArr.length / this.mChannels) / i);
        byte[] bArr2 = new byte[((int) (((long) i) * length))];
        for (int i2 = 0; ((long) i2) < length; i2++) {
            for (int i3 = 0; i3 < i; i3++) {
                bArr2[(i2 * i) + i3] = (byte) ((bArr[((this.mChannels * i2) * i) + i3] + bArr[(((this.mChannels * i2) + 1) * i) + i3]) / 2);
            }
        }
        this.mChannels = 1;
        return bArr2;
    }

    public void writeDone() {
        AppMethodBeat.m2504i(104707);
        try {
            this.mOutStream.write(this.mTmpStream.toByteArray());
            AppMethodBeat.m2505o(104707);
        } catch (IOException e) {
            Logger.m71024e(TAG, e);
            AppMethodBeat.m2505o(104707);
        }
    }

    public boolean reSampler() {
        AppMethodBeat.m2504i(104708);
        try {
            byte[] reSample = reSample(this.mTmpStream.toByteArray(), this.mSampleBits, this.mSampleRate, TXRecordCommon.AUDIO_SAMPLERATE_8000);
            if (reSample == null) {
                AppMethodBeat.m2505o(104708);
                return false;
            }
            Logger.m71020d(TAG, "mTmpStream length = " + this.mTmpStream.toByteArray().length);
            reSample = changeStereoToMono(reSample);
            Logger.m71020d(TAG, "monoData length = " + reSample.length);
            reSample = reSample(reSample, this.mSampleBits, TXRecordCommon.AUDIO_SAMPLERATE_8000, WearableStatusCodes.TARGET_NODE_NOT_CONNECTED);
            if (reSample == null) {
                AppMethodBeat.m2505o(104708);
                return false;
            }
            Logger.m71020d(TAG, "resultData length = " + reSample.length);
            this.mBytesWritten = reSample.length;
            this.mOutStream.write(reSample);
            AppMethodBeat.m2505o(104708);
            return true;
        } catch (Throwable th) {
            Logger.m71024e(TAG, th);
            AppMethodBeat.m2505o(104708);
            return false;
        }
    }

    public boolean reSamplerTo8K() {
        AppMethodBeat.m2504i(104709);
        try {
            byte[] reSample = reSample(this.mTmpStream.toByteArray(), this.mSampleBits, this.mSampleRate, TXRecordCommon.AUDIO_SAMPLERATE_8000);
            if (reSample == null) {
                AppMethodBeat.m2505o(104709);
                return false;
            }
            Logger.m71020d(TAG, "mTmpStream length = " + this.mTmpStream.toByteArray().length);
            reSample = changeStereoToMono(reSample);
            Logger.m71020d(TAG, "resultData length = " + reSample.length);
            this.mBytesWritten = reSample.length;
            this.mOutStream.write(reSample);
            AppMethodBeat.m2505o(104709);
            return true;
        } catch (Throwable th) {
            Logger.m71024e(TAG, th);
            AppMethodBeat.m2505o(104709);
            return false;
        }
    }

    private byte[] reSample(byte[] bArr, int i, int i2, int i3) {
        int i4 = 0;
        AppMethodBeat.m2504i(104710);
        int i5 = i / 8;
        if (i5 <= 0) {
            AppMethodBeat.m2505o(104710);
            return null;
        }
        byte[] bArr2;
        int length = bArr.length / i5;
        short[] sArr = new short[length];
        int i6 = 0;
        for (int i7 = 0; i7 < length; i7++) {
            int i8 = 0;
            int i9 = 0;
            while (i8 < i5) {
                i9 = (short) (i9 | ((short) ((bArr[i6] & 255) << (i8 * 8))));
                i8++;
                i6++;
            }
            sArr[i7] = i9;
        }
        short[] interpolate = interpolate(i2, i3, sArr);
        i6 = interpolate.length;
        byte[] bArr3;
        if (i5 == 1) {
            bArr3 = new byte[i6];
            while (i4 < i6) {
                bArr3[i4] = (byte) interpolate[i4];
                i4++;
            }
            bArr2 = bArr3;
        } else {
            bArr3 = new byte[(i6 * 2)];
            while (i4 < interpolate.length) {
                bArr3[i4 * 2] = (byte) (interpolate[i4] & 255);
                bArr3[(i4 * 2) + 1] = (byte) ((interpolate[i4] >> 8) & 255);
                i4++;
            }
            bArr2 = bArr3;
        }
        this.mSampleRate = i3;
        AppMethodBeat.m2505o(104710);
        return bArr2;
    }

    private short[] interpolate(int i, int i2, short[] sArr) {
        AppMethodBeat.m2504i(104711);
        if (i == i2) {
            AppMethodBeat.m2505o(104711);
            return sArr;
        }
        int round = Math.round((((float) sArr.length) / ((float) i)) * ((float) i2));
        float length = ((float) round) / ((float) sArr.length);
        short[] sArr2 = new short[round];
        for (int i3 = 0; i3 < round; i3++) {
            float f = ((float) i3) / length;
            int i4 = (int) f;
            int i5 = i4 + 1;
            if (i5 >= sArr.length) {
                i5 = sArr.length - 1;
            }
            sArr2[i3] = (short) ((int) ((((float) (sArr[i5] - sArr[i4])) * (f - ((float) i4))) + ((float) sArr[i4])));
        }
        AppMethodBeat.m2505o(104711);
        return sArr2;
    }
}
