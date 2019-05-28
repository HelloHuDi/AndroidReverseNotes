package com.tencent.ttpic.util;

import android.opengl.ETC1;
import android.opengl.ETC1Util.ETC1Texture;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.etc.ETC1File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class ZipPkmReader {
    private ByteBuffer headerBuffer;
    private ZipEntry mZipEntry;
    private ZipInputStream mZipStream;
    private String path;

    public ZipPkmReader(String str) {
        this.path = str;
    }

    public boolean open() {
        AppMethodBeat.i(84308);
        if (this.path == null) {
            AppMethodBeat.o(84308);
            return false;
        }
        try {
            if (this.path.startsWith("assets://")) {
                this.mZipStream = new ZipInputStream(VideoGlobalContext.getContext().getAssets().open(FileUtils.getRealPath(this.path)));
            } else {
                this.mZipStream = new ZipInputStream(new FileInputStream(this.path));
                this.mZipStream.reset();
            }
            AppMethodBeat.o(84308);
            return true;
        } catch (IOException e) {
            AppMethodBeat.o(84308);
            return false;
        }
    }

    public void close() {
        AppMethodBeat.i(84309);
        if (this.mZipStream != null) {
            try {
                this.mZipStream.closeEntry();
                this.mZipStream.close();
            } catch (Exception e) {
            }
            if (this.headerBuffer != null) {
                this.headerBuffer.clear();
                this.headerBuffer = null;
            }
        }
        AppMethodBeat.o(84309);
    }

    private boolean hasElements() {
        AppMethodBeat.i(84310);
        try {
            if (this.mZipStream != null) {
                this.mZipEntry = this.mZipStream.getNextEntry();
                if (this.mZipEntry != null) {
                    AppMethodBeat.o(84310);
                    return true;
                }
            }
        } catch (IOException e) {
        }
        AppMethodBeat.o(84310);
        return false;
    }

    public InputStream getNextStream() {
        AppMethodBeat.i(84311);
        if (hasElements()) {
            ZipInputStream zipInputStream = this.mZipStream;
            AppMethodBeat.o(84311);
            return zipInputStream;
        }
        AppMethodBeat.o(84311);
        return null;
    }

    public ETC1Texture getNextTexture() {
        AppMethodBeat.i(84312);
        if (hasElements()) {
            try {
                ETC1Texture createTexture = createTexture(this.mZipStream);
                AppMethodBeat.o(84312);
                return createTexture;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.o(84312);
        return null;
    }

    public ETC1File getNextEntry() {
        AppMethodBeat.i(84313);
        ETC1Texture nextTexture = getNextTexture();
        if (nextTexture == null || this.mZipEntry.getName().contains("../")) {
            AppMethodBeat.o(84313);
            return null;
        }
        ETC1File eTC1File = new ETC1File(this.mZipEntry.getName(), nextTexture);
        AppMethodBeat.o(84313);
        return eTC1File;
    }

    private ETC1Texture createTexture(InputStream inputStream) {
        AppMethodBeat.i(84314);
        byte[] bArr = new byte[4096];
        IOException iOException;
        if (inputStream.read(bArr, 0, 16) != 16) {
            iOException = new IOException("Unable to read PKM file header.");
            AppMethodBeat.o(84314);
            throw iOException;
        }
        if (this.headerBuffer == null) {
            this.headerBuffer = ByteBuffer.allocateDirect(16).order(ByteOrder.nativeOrder());
        }
        this.headerBuffer.put(bArr, 0, 16).position(0);
        if (ETC1.isValid(this.headerBuffer)) {
            int width = ETC1.getWidth(this.headerBuffer);
            int height = ETC1.getHeight(this.headerBuffer);
            ByteBuffer order = ByteBuffer.allocateDirect(ETC1.getEncodedDataSize(width, height)).order(ByteOrder.nativeOrder());
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    order.put(bArr, 0, read);
                } else {
                    order.position(0);
                    ETC1Texture eTC1Texture = new ETC1Texture(width, height, order);
                    AppMethodBeat.o(84314);
                    return eTC1Texture;
                }
            }
        }
        iOException = new IOException("Not a PKM file.");
        AppMethodBeat.o(84314);
        throw iOException;
    }

    public void reset() {
        AppMethodBeat.i(84315);
        close();
        open();
        AppMethodBeat.o(84315);
    }
}
