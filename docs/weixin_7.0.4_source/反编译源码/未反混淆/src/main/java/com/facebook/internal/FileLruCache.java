package com.facebook.internal;

import com.facebook.FacebookSdk;
import com.facebook.LoggingBehavior;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.FilterEnum4Shaka;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidParameterException;
import java.util.Date;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

public final class FileLruCache {
    private static final String HEADER_CACHEKEY_KEY = "key";
    private static final String HEADER_CACHE_CONTENT_TAG_KEY = "tag";
    static final String TAG = FileLruCache.class.getSimpleName();
    private static final AtomicLong bufferIndex = new AtomicLong();
    private final File directory;
    private boolean isTrimInProgress;
    private boolean isTrimPending;
    private AtomicLong lastClearCacheTime = new AtomicLong(0);
    private final Limits limits;
    private final Object lock;
    private final String tag;

    public static final class Limits {
        private int byteCount = 1048576;
        private int fileCount = WXMediaMessage.DESCRIPTION_LENGTH_LIMIT;

        /* Access modifiers changed, original: final */
        public final int getByteCount() {
            return this.byteCount;
        }

        /* Access modifiers changed, original: final */
        public final int getFileCount() {
            return this.fileCount;
        }

        /* Access modifiers changed, original: final */
        public final void setByteCount(int i) {
            AppMethodBeat.i(72344);
            if (i < 0) {
                InvalidParameterException invalidParameterException = new InvalidParameterException("Cache byte-count limit must be >= 0");
                AppMethodBeat.o(72344);
                throw invalidParameterException;
            }
            this.byteCount = i;
            AppMethodBeat.o(72344);
        }

        /* Access modifiers changed, original: final */
        public final void setFileCount(int i) {
            AppMethodBeat.i(72345);
            if (i < 0) {
                InvalidParameterException invalidParameterException = new InvalidParameterException("Cache file count limit must be >= 0");
                AppMethodBeat.o(72345);
                throw invalidParameterException;
            }
            this.fileCount = i;
            AppMethodBeat.o(72345);
        }
    }

    static final class StreamHeader {
        private static final int HEADER_VERSION = 0;

        private StreamHeader() {
        }

        static void writeHeader(OutputStream outputStream, JSONObject jSONObject) {
            AppMethodBeat.i(72351);
            byte[] bytes = jSONObject.toString().getBytes();
            outputStream.write(0);
            outputStream.write((bytes.length >> 16) & 255);
            outputStream.write((bytes.length >> 8) & 255);
            outputStream.write((bytes.length >> 0) & 255);
            outputStream.write(bytes);
            AppMethodBeat.o(72351);
        }

        static JSONObject readHeader(InputStream inputStream) {
            int i = 0;
            AppMethodBeat.i(72352);
            if (inputStream.read() != 0) {
                AppMethodBeat.o(72352);
                return null;
            }
            int read;
            int i2 = 0;
            for (int i3 = 0; i3 < 3; i3++) {
                read = inputStream.read();
                if (read == -1) {
                    Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read returned -1 while reading header size");
                    AppMethodBeat.o(72352);
                    return null;
                }
                i2 = (i2 << 8) + (read & 255);
            }
            byte[] bArr = new byte[i2];
            while (i < i2) {
                read = inputStream.read(bArr, i, i2 - i);
                if (read <= 0) {
                    Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: stream.read stopped at " + Integer.valueOf(i) + " when expected " + i2);
                    AppMethodBeat.o(72352);
                    return null;
                }
                i += read;
            }
            try {
                Object nextValue = new JSONTokener(new String(bArr)).nextValue();
                if (nextValue instanceof JSONObject) {
                    JSONObject jSONObject = (JSONObject) nextValue;
                    AppMethodBeat.o(72352);
                    return jSONObject;
                }
                Logger.log(LoggingBehavior.CACHE, FileLruCache.TAG, "readHeader: expected JSONObject, got " + nextValue.getClass().getCanonicalName());
                AppMethodBeat.o(72352);
                return null;
            } catch (JSONException e) {
                IOException iOException = new IOException(e.getMessage());
                AppMethodBeat.o(72352);
                throw iOException;
            }
        }
    }

    static class BufferFile {
        private static final String FILE_NAME_PREFIX = "buffer";
        private static final FilenameFilter filterExcludeBufferFiles = new FilenameFilter() {
            public final boolean accept(File file, String str) {
                AppMethodBeat.i(72326);
                if (str.startsWith(BufferFile.FILE_NAME_PREFIX)) {
                    AppMethodBeat.o(72326);
                    return false;
                }
                AppMethodBeat.o(72326);
                return true;
            }
        };
        private static final FilenameFilter filterExcludeNonBufferFiles = new FilenameFilter() {
            public final boolean accept(File file, String str) {
                AppMethodBeat.i(72327);
                boolean startsWith = str.startsWith(BufferFile.FILE_NAME_PREFIX);
                AppMethodBeat.o(72327);
                return startsWith;
            }
        };

        private BufferFile() {
        }

        static {
            AppMethodBeat.i(72330);
            AppMethodBeat.o(72330);
        }

        static void deleteAll(File file) {
            AppMethodBeat.i(72328);
            File[] listFiles = file.listFiles(excludeNonBufferFiles());
            if (listFiles != null) {
                for (File delete : listFiles) {
                    delete.delete();
                }
            }
            AppMethodBeat.o(72328);
        }

        static FilenameFilter excludeBufferFiles() {
            return filterExcludeBufferFiles;
        }

        static FilenameFilter excludeNonBufferFiles() {
            return filterExcludeNonBufferFiles;
        }

        static File newFile(File file) {
            AppMethodBeat.i(72329);
            File file2 = new File(file, new StringBuilder(FILE_NAME_PREFIX).append(Long.valueOf(FileLruCache.bufferIndex.incrementAndGet()).toString()).toString());
            AppMethodBeat.o(72329);
            return file2;
        }
    }

    static class CloseCallbackOutputStream extends OutputStream {
        final StreamCloseCallback callback;
        final OutputStream innerStream;

        CloseCallbackOutputStream(OutputStream outputStream, StreamCloseCallback streamCloseCallback) {
            this.innerStream = outputStream;
            this.callback = streamCloseCallback;
        }

        public void close() {
            AppMethodBeat.i(72331);
            try {
                this.innerStream.close();
            } finally {
                this.callback.onClose();
                AppMethodBeat.o(72331);
            }
        }

        public void flush() {
            AppMethodBeat.i(72332);
            this.innerStream.flush();
            AppMethodBeat.o(72332);
        }

        public void write(byte[] bArr, int i, int i2) {
            AppMethodBeat.i(72333);
            this.innerStream.write(bArr, i, i2);
            AppMethodBeat.o(72333);
        }

        public void write(byte[] bArr) {
            AppMethodBeat.i(72334);
            this.innerStream.write(bArr);
            AppMethodBeat.o(72334);
        }

        public void write(int i) {
            AppMethodBeat.i(72335);
            this.innerStream.write(i);
            AppMethodBeat.o(72335);
        }
    }

    static final class CopyingInputStream extends InputStream {
        final InputStream input;
        final OutputStream output;

        CopyingInputStream(InputStream inputStream, OutputStream outputStream) {
            this.input = inputStream;
            this.output = outputStream;
        }

        public final int available() {
            AppMethodBeat.i(72336);
            int available = this.input.available();
            AppMethodBeat.o(72336);
            return available;
        }

        public final void close() {
            AppMethodBeat.i(72337);
            try {
                this.input.close();
            } finally {
                this.output.close();
                AppMethodBeat.o(72337);
            }
        }

        public final void mark(int i) {
            AppMethodBeat.i(72338);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(72338);
            throw unsupportedOperationException;
        }

        public final boolean markSupported() {
            return false;
        }

        public final int read(byte[] bArr) {
            AppMethodBeat.i(72339);
            int read = this.input.read(bArr);
            if (read > 0) {
                this.output.write(bArr, 0, read);
            }
            AppMethodBeat.o(72339);
            return read;
        }

        public final int read() {
            AppMethodBeat.i(72340);
            int read = this.input.read();
            if (read >= 0) {
                this.output.write(read);
            }
            AppMethodBeat.o(72340);
            return read;
        }

        public final int read(byte[] bArr, int i, int i2) {
            AppMethodBeat.i(72341);
            int read = this.input.read(bArr, i, i2);
            if (read > 0) {
                this.output.write(bArr, i, read);
            }
            AppMethodBeat.o(72341);
            return read;
        }

        public final synchronized void reset() {
            AppMethodBeat.i(72342);
            UnsupportedOperationException unsupportedOperationException = new UnsupportedOperationException();
            AppMethodBeat.o(72342);
            throw unsupportedOperationException;
        }

        public final long skip(long j) {
            AppMethodBeat.i(72343);
            byte[] bArr = new byte[WXMediaMessage.DESCRIPTION_LENGTH_LIMIT];
            long j2 = 0;
            while (j2 < j) {
                int read = read(bArr, 0, (int) Math.min(j - j2, 1024));
                if (read < 0) {
                    AppMethodBeat.o(72343);
                    break;
                }
                j2 += (long) read;
            }
            AppMethodBeat.o(72343);
            return j2;
        }
    }

    static final class ModifiedFile implements Comparable<ModifiedFile> {
        private static final int HASH_MULTIPLIER = 37;
        private static final int HASH_SEED = 29;
        private final File file;
        private final long modified;

        ModifiedFile(File file) {
            AppMethodBeat.i(72346);
            this.file = file;
            this.modified = file.lastModified();
            AppMethodBeat.o(72346);
        }

        /* Access modifiers changed, original: final */
        public final File getFile() {
            return this.file;
        }

        /* Access modifiers changed, original: final */
        public final long getModified() {
            return this.modified;
        }

        public final int compareTo(ModifiedFile modifiedFile) {
            AppMethodBeat.i(72347);
            if (getModified() < modifiedFile.getModified()) {
                AppMethodBeat.o(72347);
                return -1;
            } else if (getModified() > modifiedFile.getModified()) {
                AppMethodBeat.o(72347);
                return 1;
            } else {
                int compareTo = getFile().compareTo(modifiedFile.getFile());
                AppMethodBeat.o(72347);
                return compareTo;
            }
        }

        public final boolean equals(Object obj) {
            AppMethodBeat.i(72348);
            if ((obj instanceof ModifiedFile) && compareTo((ModifiedFile) obj) == 0) {
                AppMethodBeat.o(72348);
                return true;
            }
            AppMethodBeat.o(72348);
            return false;
        }

        public final int hashCode() {
            AppMethodBeat.i(72349);
            int hashCode = ((this.file.hashCode() + FilterEnum4Shaka.MIC_WEISHI_MENGHUANG) * 37) + ((int) (this.modified % 2147483647L));
            AppMethodBeat.o(72349);
            return hashCode;
        }
    }

    interface StreamCloseCallback {
        void onClose();
    }

    static /* synthetic */ void access$100(FileLruCache fileLruCache, String str, File file) {
        AppMethodBeat.i(72366);
        fileLruCache.renameToTargetAndTrim(str, file);
        AppMethodBeat.o(72366);
    }

    static /* synthetic */ void access$200(FileLruCache fileLruCache) {
        AppMethodBeat.i(72367);
        fileLruCache.trim();
        AppMethodBeat.o(72367);
    }

    static {
        AppMethodBeat.i(72368);
        AppMethodBeat.o(72368);
    }

    public FileLruCache(String str, Limits limits) {
        AppMethodBeat.i(72353);
        this.tag = str;
        this.limits = limits;
        this.directory = new File(FacebookSdk.getCacheDir(), str);
        this.lock = new Object();
        if (this.directory.mkdirs() || this.directory.isDirectory()) {
            BufferFile.deleteAll(this.directory);
        }
        AppMethodBeat.o(72353);
    }

    /* Access modifiers changed, original: final */
    public final long sizeInBytesForTest() {
        AppMethodBeat.i(72354);
        synchronized (this.lock) {
            while (true) {
                try {
                    if (!this.isTrimPending && !this.isTrimInProgress) {
                        break;
                    }
                    try {
                        this.lock.wait();
                    } catch (InterruptedException e) {
                    }
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(72354);
                    }
                }
            }
        }
        File[] listFiles = this.directory.listFiles();
        long j = 0;
        if (listFiles != null) {
            for (File length : listFiles) {
                j += length.length();
            }
        }
        AppMethodBeat.o(72354);
        return j;
    }

    public final InputStream get(String str) {
        AppMethodBeat.i(72355);
        InputStream inputStream = get(str, null);
        AppMethodBeat.o(72355);
        return inputStream;
    }

    public final InputStream get(String str, String str2) {
        AppMethodBeat.i(72356);
        File file = new File(this.directory, Utility.md5hash(str));
        try {
            InputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file), Utility.DEFAULT_STREAM_BUFFER_SIZE);
            try {
                JSONObject readHeader = StreamHeader.readHeader(bufferedInputStream);
                if (readHeader == null) {
                    return null;
                }
                String optString = readHeader.optString(HEADER_CACHEKEY_KEY);
                if (optString == null || !optString.equals(str)) {
                    bufferedInputStream.close();
                    AppMethodBeat.o(72356);
                    return null;
                }
                String optString2 = readHeader.optString(HEADER_CACHE_CONTENT_TAG_KEY, null);
                if ((str2 != null || optString2 == null) && (str2 == null || str2.equals(optString2))) {
                    long time = new Date().getTime();
                    Logger.log(LoggingBehavior.CACHE, TAG, "Setting lastModified to " + Long.valueOf(time) + " for " + file.getName());
                    file.setLastModified(time);
                    AppMethodBeat.o(72356);
                    return bufferedInputStream;
                }
                bufferedInputStream.close();
                AppMethodBeat.o(72356);
                return null;
            } finally {
                bufferedInputStream.close();
                AppMethodBeat.o(72356);
            }
        } catch (IOException e) {
            AppMethodBeat.o(72356);
            return null;
        }
    }

    public final OutputStream openPutStream(String str) {
        AppMethodBeat.i(72357);
        OutputStream openPutStream = openPutStream(str, null);
        AppMethodBeat.o(72357);
        return openPutStream;
    }

    public final OutputStream openPutStream(String str, String str2) {
        IOException iOException;
        AppMethodBeat.i(72358);
        final File newFile = BufferFile.newFile(this.directory);
        newFile.delete();
        if (newFile.createNewFile()) {
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(newFile);
                final long currentTimeMillis = System.currentTimeMillis();
                final String str3 = str;
                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new CloseCallbackOutputStream(fileOutputStream, new StreamCloseCallback() {
                    public void onClose() {
                        AppMethodBeat.i(72323);
                        if (currentTimeMillis < FileLruCache.this.lastClearCacheTime.get()) {
                            newFile.delete();
                            AppMethodBeat.o(72323);
                            return;
                        }
                        FileLruCache.access$100(FileLruCache.this, str3, newFile);
                        AppMethodBeat.o(72323);
                    }
                }), Utility.DEFAULT_STREAM_BUFFER_SIZE);
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(HEADER_CACHEKEY_KEY, str);
                    if (!Utility.isNullOrEmpty(str2)) {
                        jSONObject.put(HEADER_CACHE_CONTENT_TAG_KEY, str2);
                    }
                    StreamHeader.writeHeader(bufferedOutputStream, jSONObject);
                    AppMethodBeat.o(72358);
                    return bufferedOutputStream;
                } catch (JSONException e) {
                    Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error creating JSON header for cache file: ".concat(String.valueOf(e)));
                    iOException = new IOException(e.getMessage());
                    AppMethodBeat.o(72358);
                    throw iOException;
                } catch (Throwable th) {
                    bufferedOutputStream.close();
                    AppMethodBeat.o(72358);
                }
            } catch (FileNotFoundException e2) {
                Logger.log(LoggingBehavior.CACHE, 5, TAG, "Error creating buffer output stream: ".concat(String.valueOf(e2)));
                iOException = new IOException(e2.getMessage());
                AppMethodBeat.o(72358);
                throw iOException;
            }
        }
        IOException iOException2 = new IOException("Could not create file at " + newFile.getAbsolutePath());
        AppMethodBeat.o(72358);
        throw iOException2;
    }

    public final void clearCache() {
        AppMethodBeat.i(72359);
        final File[] listFiles = this.directory.listFiles(BufferFile.excludeBufferFiles());
        this.lastClearCacheTime.set(System.currentTimeMillis());
        if (listFiles != null) {
            FacebookSdk.getExecutor().execute(new Runnable() {
                public void run() {
                    AppMethodBeat.i(72324);
                    for (File delete : listFiles) {
                        delete.delete();
                    }
                    AppMethodBeat.o(72324);
                }
            });
        }
        AppMethodBeat.o(72359);
    }

    public final String getLocation() {
        AppMethodBeat.i(72360);
        String path = this.directory.getPath();
        AppMethodBeat.o(72360);
        return path;
    }

    private void renameToTargetAndTrim(String str, File file) {
        AppMethodBeat.i(72361);
        if (!file.renameTo(new File(this.directory, Utility.md5hash(str)))) {
            file.delete();
        }
        postTrim();
        AppMethodBeat.o(72361);
    }

    public final InputStream interceptAndPut(String str, InputStream inputStream) {
        AppMethodBeat.i(72362);
        CopyingInputStream copyingInputStream = new CopyingInputStream(inputStream, openPutStream(str));
        AppMethodBeat.o(72362);
        return copyingInputStream;
    }

    public final String toString() {
        AppMethodBeat.i(72363);
        String str = "{FileLruCache: tag:" + this.tag + " file:" + this.directory.getName() + "}";
        AppMethodBeat.o(72363);
        return str;
    }

    private void postTrim() {
        AppMethodBeat.i(72364);
        synchronized (this.lock) {
            try {
                if (!this.isTrimPending) {
                    this.isTrimPending = true;
                    FacebookSdk.getExecutor().execute(new Runnable() {
                        public void run() {
                            AppMethodBeat.i(72325);
                            FileLruCache.access$200(FileLruCache.this);
                            AppMethodBeat.o(72325);
                        }
                    });
                }
            } finally {
                while (true) {
                }
                AppMethodBeat.o(72364);
            }
        }
    }

    private void trim() {
        AppMethodBeat.i(72365);
        synchronized (this.lock) {
            try {
                this.isTrimPending = false;
                this.isTrimInProgress = true;
            } finally {
                while (true) {
                }
                AppMethodBeat.o(72365);
            }
        }
        try {
            Logger.log(LoggingBehavior.CACHE, TAG, "trim started");
            PriorityQueue priorityQueue = new PriorityQueue();
            long j = 0;
            long j2 = 0;
            File[] listFiles = this.directory.listFiles(BufferFile.excludeBufferFiles());
            if (listFiles != null) {
                for (File file : listFiles) {
                    ModifiedFile modifiedFile = new ModifiedFile(file);
                    priorityQueue.add(modifiedFile);
                    Logger.log(LoggingBehavior.CACHE, TAG, "  trim considering time=" + Long.valueOf(modifiedFile.getModified()) + " name=" + modifiedFile.getFile().getName());
                    j += file.length();
                    j2++;
                }
            }
            while (true) {
                long j3 = j2;
                if (j <= ((long) this.limits.getByteCount()) && j3 <= ((long) this.limits.getFileCount())) {
                    break;
                }
                File file2 = ((ModifiedFile) priorityQueue.remove()).getFile();
                Logger.log(LoggingBehavior.CACHE, TAG, "  trim removing " + file2.getName());
                j -= file2.length();
                j2 = j3 - 1;
                file2.delete();
            }
            synchronized (this.lock) {
                try {
                    this.isTrimInProgress = false;
                    this.lock.notifyAll();
                } catch (Throwable th) {
                    while (true) {
                        AppMethodBeat.o(72365);
                    }
                }
            }
        } catch (Throwable th2) {
            synchronized (this.lock) {
                this.isTrimInProgress = false;
                this.lock.notifyAll();
            }
        } finally {
            while (true) {
            }
            AppMethodBeat.o(72365);
        }
    }
}
