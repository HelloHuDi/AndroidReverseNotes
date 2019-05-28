package com.tencent.ttpic.gles;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.nio.ByteBuffer;

public class GeneratedTexture {
    private static final int BLACK = 0;
    private static final int BLUE = 16711680;
    private static final int BYTES_PER_PIXEL = 4;
    private static final int CYAN = 16776960;
    private static final int FORMAT = 6408;
    private static final int GREEN = 65280;
    private static final int[] GRID = new int[]{-16776961, -16711681, -16711936, -65281, -1, 1073742079, 1073807104, -16711681, -65281, GREEN, -2147483393, -16777216, -256, -65281, -256, -65536};
    private static final int HALF = Integer.MIN_VALUE;
    private static final int LOW = 1073741824;
    private static final int MAGENTA = 16711935;
    private static final int OPAQUE = -16777216;
    private static final int RED = 255;
    private static final int TEX_SIZE = 64;
    private static final int TRANSP = 0;
    private static final int WHITE = 16777215;
    private static final int YELLOW = 65535;
    private static final ByteBuffer sCoarseImageData = generateCoarseData();
    private static final ByteBuffer sFineImageData = generateFineData();

    public enum Image {
        COARSE,
        FINE;

        static {
            AppMethodBeat.m2505o(49993);
        }
    }

    static {
        AppMethodBeat.m2504i(49997);
        AppMethodBeat.m2505o(49997);
    }

    public static int createTestTexture(Image image) {
        ByteBuffer byteBuffer;
        AppMethodBeat.m2504i(49994);
        switch (image) {
            case COARSE:
                byteBuffer = sCoarseImageData;
                break;
            case FINE:
                byteBuffer = sFineImageData;
                break;
            default:
                RuntimeException runtimeException = new RuntimeException("unknown image");
                AppMethodBeat.m2505o(49994);
                throw runtimeException;
        }
        int createImageTexture = GlUtil.createImageTexture(byteBuffer, 64, 64, 6408);
        AppMethodBeat.m2505o(49994);
        return createImageTexture;
    }

    private static ByteBuffer generateCoarseData() {
        AppMethodBeat.m2504i(49995);
        byte[] bArr = new byte[16384];
        for (int i = 0; i < 16384; i += 4) {
            int i2 = GRID[((((i / 4) / 64) / 16) * 4) + (((i / 4) % 64) / 16)];
            if (i == 0) {
                i2 = -1;
            } else if (i == 16380) {
                i2 = -1;
            }
            int i3 = i2 & 255;
            int i4 = (i2 >> 8) & 255;
            int i5 = (i2 >> 16) & 255;
            i2 = (i2 >> 24) & 255;
            float f = ((float) i2) / 255.0f;
            bArr[i] = (byte) ((int) (((float) i3) * f));
            bArr[i + 1] = (byte) ((int) (((float) i4) * f));
            bArr[i + 2] = (byte) ((int) (((float) i5) * f));
            bArr[i + 3] = (byte) i2;
        }
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(16384);
        allocateDirect.put(bArr);
        allocateDirect.position(0);
        AppMethodBeat.m2505o(49995);
        return allocateDirect;
    }

    private static ByteBuffer generateFineData() {
        AppMethodBeat.m2504i(49996);
        byte[] bArr = new byte[16384];
        checkerPattern(bArr, 0, 0, 32, 32, -16776961, -65536, 1);
        checkerPattern(bArr, 32, 32, 64, 64, -16776961, -16711936, 2);
        checkerPattern(bArr, 0, 32, 32, 64, -65536, -16711936, 4);
        checkerPattern(bArr, 32, 0, 64, 32, -1, -16777216, 8);
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(16384);
        allocateDirect.put(bArr);
        allocateDirect.position(0);
        AppMethodBeat.m2505o(49996);
        return allocateDirect;
    }

    private static void checkerPattern(byte[] bArr, int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        while (i2 < i4) {
            int i8 = (i2 * 64) * 4;
            for (int i9 = i; i9 < i3; i9++) {
                int i10;
                int i11 = i8 + (i9 * 4);
                if (((i2 & i7) ^ (i9 & i7)) == 0) {
                    i10 = i5;
                } else {
                    i10 = i6;
                }
                int i12 = i10 & 255;
                int i13 = (i10 >> 8) & 255;
                int i14 = (i10 >> 16) & 255;
                i10 = (i10 >> 24) & 255;
                float f = ((float) i10) / 255.0f;
                bArr[i11] = (byte) ((int) (((float) i12) * f));
                bArr[i11 + 1] = (byte) ((int) (((float) i13) * f));
                bArr[i11 + 2] = (byte) ((int) (((float) i14) * f));
                bArr[i11 + 3] = (byte) i10;
            }
            i2++;
        }
    }
}
