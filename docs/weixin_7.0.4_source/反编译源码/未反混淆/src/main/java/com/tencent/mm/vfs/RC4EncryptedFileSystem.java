package com.tencent.mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.vfs.FileSystemManager.b;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.GeneralSecurityException;
import java.security.Key;
import java.util.Collections;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.CipherOutputStream;

public class RC4EncryptedFileSystem extends FileBasedFileSystem {
    public static final Creator<RC4EncryptedFileSystem> CREATOR = new Creator<RC4EncryptedFileSystem>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RC4EncryptedFileSystem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(54570);
            RC4EncryptedFileSystem rC4EncryptedFileSystem = new RC4EncryptedFileSystem(parcel, (byte) 0);
            AppMethodBeat.o(54570);
            return rC4EncryptedFileSystem;
        }
    };
    private final String eIq;
    private final b zZG;
    private final boolean zZH;
    private volatile Key zZI;

    public RC4EncryptedFileSystem(String str, String str2) {
        super(str);
        AppMethodBeat.i(54571);
        this.zZG = FileSystemManager.enr();
        this.eIq = str2;
        if (this.zZG == null) {
            RuntimeException runtimeException = new RuntimeException("Set global generator by calling setKeyGenerator(...) before initializing FileSystem objects.");
            AppMethodBeat.o(54571);
            throw runtimeException;
        }
        this.zZI = this.zZG.e(this.eIq, Collections.unmodifiableMap(FileSystemManager.dMy().Caf));
        this.zZH = this.zZI != null;
        AppMethodBeat.o(54571);
    }

    private RC4EncryptedFileSystem(Parcel parcel) {
        super(parcel);
        AppMethodBeat.i(54572);
        j.a(parcel, getClass());
        this.zZG = FileSystemManager.enr();
        this.eIq = parcel.readString();
        if (this.zZG == null) {
            RuntimeException runtimeException = new RuntimeException("Set global generator by calling setGlobalKeyGenerator(...) before initializing FileSystem objects.");
            AppMethodBeat.o(54572);
            throw runtimeException;
        }
        this.zZI = this.zZG.e(this.eIq, Collections.unmodifiableMap(FileSystemManager.dMy().Caf));
        this.zZH = this.zZI != null;
        AppMethodBeat.o(54572);
    }

    public final InputStream openRead(String str) {
        AppMethodBeat.i(54573);
        Key key = this.zZI;
        IOException iOException;
        if (key == null) {
            iOException = new IOException("Key is not initialized.");
            AppMethodBeat.o(54573);
            throw iOException;
        }
        String O = O(str, false);
        if (O == null) {
            iOException = new IOException("Invalid path: ".concat(String.valueOf(str)));
            AppMethodBeat.o(54573);
            throw iOException;
        }
        try {
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(2, key);
            CipherInputStream cipherInputStream = new CipherInputStream(new FileInputStream(O), instance);
            AppMethodBeat.o(54573);
            return cipherInputStream;
        } catch (GeneralSecurityException e) {
            FileNotFoundException fileNotFoundException = (FileNotFoundException) new FileNotFoundException("Failed to initialize cipher: " + e.getMessage()).initCause(e);
            AppMethodBeat.o(54573);
            throw fileNotFoundException;
        }
    }

    public final OutputStream L(String str, boolean z) {
        AppMethodBeat.i(54574);
        Key key = this.zZI;
        IOException iOException;
        if (key == null) {
            iOException = new IOException("Key is not initialized.");
            AppMethodBeat.o(54574);
            throw iOException;
        } else if (this.mReadOnly) {
            iOException = new IOException("Cannot open files for writing on read-only file systems");
            AppMethodBeat.o(54574);
            throw iOException;
        } else {
            String O = O(str, true);
            if (O == null) {
                iOException = new IOException("Invalid path: ".concat(String.valueOf(str)));
                AppMethodBeat.o(54574);
                throw iOException;
            }
            try {
                Cipher instance = Cipher.getInstance("RC4");
                instance.init(1, key);
                CipherOutputStream cipherOutputStream = new CipherOutputStream(new FileOutputStream(O, z), instance);
                AppMethodBeat.o(54574);
                return cipherOutputStream;
            } catch (GeneralSecurityException e) {
                FileNotFoundException fileNotFoundException = (FileNotFoundException) new FileNotFoundException("Failed to initialize cipher: " + e.getMessage()).initCause(e);
                AppMethodBeat.o(54574);
                throw fileNotFoundException;
            }
        }
    }

    public final void p(Map<String, String> map) {
        AppMethodBeat.i(54575);
        super.p(map);
        if (!this.zZH) {
            this.zZI = this.zZG.e(this.eIq, map);
        }
        AppMethodBeat.o(54575);
    }

    public String toString() {
        AppMethodBeat.i(54576);
        StringBuilder append = new StringBuilder("RC4FS [").append(dMt());
        if (this.mReadOnly) {
            append.append(", read-only");
        }
        String stringBuilder = append.append(']').toString();
        AppMethodBeat.o(54576);
        return stringBuilder;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(54577);
        super.writeToParcel(parcel, i);
        parcel.writeInt(1);
        parcel.writeString(this.eIq);
        AppMethodBeat.o(54577);
    }

    static {
        AppMethodBeat.i(54578);
        AppMethodBeat.o(54578);
    }
}
