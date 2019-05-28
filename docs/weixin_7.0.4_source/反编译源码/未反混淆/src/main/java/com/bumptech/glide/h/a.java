package com.bumptech.glide.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.util.concurrent.atomic.AtomicReference;

public final class a {
    private static final AtomicReference<byte[]> aHU = new AtomicReference();

    static final class b {
        final byte[] data;
        final int limit;
        final int offset;

        b(byte[] bArr, int i, int i2) {
            this.data = bArr;
            this.offset = i;
            this.limit = i2;
        }
    }

    static class a extends InputStream {
        private int aHV = -1;
        private final ByteBuffer byteBuffer;

        a(ByteBuffer byteBuffer) {
            this.byteBuffer = byteBuffer;
        }

        public final int available() {
            AppMethodBeat.i(92542);
            int remaining = this.byteBuffer.remaining();
            AppMethodBeat.o(92542);
            return remaining;
        }

        public final int read() {
            AppMethodBeat.i(92543);
            if (this.byteBuffer.hasRemaining()) {
                int i = this.byteBuffer.get();
                AppMethodBeat.o(92543);
                return i;
            }
            AppMethodBeat.o(92543);
            return -1;
        }

        public final synchronized void mark(int i) {
            AppMethodBeat.i(92544);
            this.aHV = this.byteBuffer.position();
            AppMethodBeat.o(92544);
        }

        public final boolean markSupported() {
            return true;
        }

        public final int read(byte[] bArr, int i, int i2) {
            AppMethodBeat.i(92545);
            if (this.byteBuffer.hasRemaining()) {
                int min = Math.min(i2, available());
                this.byteBuffer.get(bArr, i, min);
                AppMethodBeat.o(92545);
                return min;
            }
            AppMethodBeat.o(92545);
            return -1;
        }

        public final synchronized void reset() {
            AppMethodBeat.i(92546);
            if (this.aHV == -1) {
                IOException iOException = new IOException("Cannot reset to unset mark position");
                AppMethodBeat.o(92546);
                throw iOException;
            }
            this.byteBuffer.position(this.aHV);
            AppMethodBeat.o(92546);
        }

        public final long skip(long j) {
            AppMethodBeat.i(92547);
            if (this.byteBuffer.hasRemaining()) {
                long min = Math.min(j, (long) available());
                this.byteBuffer.position((int) (((long) this.byteBuffer.position()) + min));
                AppMethodBeat.o(92547);
                return min;
            }
            AppMethodBeat.o(92547);
            return -1;
        }
    }

    static {
        AppMethodBeat.i(92552);
        AppMethodBeat.o(92552);
    }

    public static ByteBuffer p(File file) {
        Throwable th;
        FileChannel fileChannel;
        RandomAccessFile randomAccessFile;
        AppMethodBeat.i(92548);
        try {
            long length = file.length();
            IOException iOException;
            if (length > 2147483647L) {
                iOException = new IOException("File too large to map into memory");
                AppMethodBeat.o(92548);
                throw iOException;
            } else if (length == 0) {
                iOException = new IOException("File unsuitable for memory mapping");
                AppMethodBeat.o(92548);
                throw iOException;
            } else {
                RandomAccessFile randomAccessFile2 = new RandomAccessFile(file, "r");
                try {
                    FileChannel channel = randomAccessFile2.getChannel();
                    try {
                        MappedByteBuffer load = channel.map(MapMode.READ_ONLY, 0, length).load();
                        if (channel != null) {
                            try {
                                channel.close();
                            } catch (IOException e) {
                            }
                        }
                        try {
                            randomAccessFile2.close();
                        } catch (IOException e2) {
                        }
                        AppMethodBeat.o(92548);
                        return load;
                    } catch (Throwable th2) {
                        th = th2;
                        fileChannel = channel;
                        randomAccessFile = randomAccessFile2;
                    }
                } catch (Throwable th3) {
                    th = th3;
                    fileChannel = null;
                    randomAccessFile = randomAccessFile2;
                }
            }
        } catch (Throwable th32) {
            th = th32;
            fileChannel = null;
            randomAccessFile = null;
            if (fileChannel != null) {
                try {
                    fileChannel.close();
                } catch (IOException e3) {
                }
            }
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e4) {
                }
            }
            AppMethodBeat.o(92548);
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x003a A:{SYNTHETIC, Splitter:B:18:0x003a} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x003f A:{SYNTHETIC, Splitter:B:21:0x003f} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void b(ByteBuffer byteBuffer, File file) {
        Throwable th;
        AppMethodBeat.i(92549);
        byteBuffer.position(0);
        RandomAccessFile randomAccessFile;
        FileChannel channel;
        try {
            randomAccessFile = new RandomAccessFile(file, "rw");
            try {
                channel = randomAccessFile.getChannel();
                try {
                    channel.write(byteBuffer);
                    channel.force(false);
                    channel.close();
                    randomAccessFile.close();
                    if (channel != null) {
                        try {
                            channel.close();
                        } catch (IOException e) {
                        }
                    }
                    try {
                        randomAccessFile.close();
                        AppMethodBeat.o(92549);
                    } catch (IOException e2) {
                        AppMethodBeat.o(92549);
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (channel != null) {
                    }
                    if (randomAccessFile != null) {
                    }
                    AppMethodBeat.o(92549);
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                channel = null;
            }
        } catch (Throwable th4) {
            th = th4;
            channel = null;
            randomAccessFile = null;
            if (channel != null) {
                try {
                    channel.close();
                } catch (IOException e3) {
                }
            }
            if (randomAccessFile != null) {
                try {
                    randomAccessFile.close();
                } catch (IOException e4) {
                }
            }
            AppMethodBeat.o(92549);
            throw th;
        }
    }

    public static InputStream e(ByteBuffer byteBuffer) {
        AppMethodBeat.i(92551);
        a aVar = new a(byteBuffer);
        AppMethodBeat.o(92551);
        return aVar;
    }

    public static byte[] d(ByteBuffer byteBuffer) {
        b bVar;
        byte[] array;
        AppMethodBeat.i(92550);
        if (byteBuffer.isReadOnly() || !byteBuffer.hasArray()) {
            bVar = null;
        } else {
            bVar = new b(byteBuffer.array(), byteBuffer.arrayOffset(), byteBuffer.limit());
        }
        if (bVar != null && bVar.offset == 0 && bVar.limit == bVar.data.length) {
            array = byteBuffer.array();
        } else {
            ByteBuffer asReadOnlyBuffer = byteBuffer.asReadOnlyBuffer();
            array = new byte[asReadOnlyBuffer.limit()];
            asReadOnlyBuffer.position(0);
            asReadOnlyBuffer.get(array);
        }
        AppMethodBeat.o(92550);
        return array;
    }
}
