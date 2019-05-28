package com.tencent.p177mm.vfs;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.vfs.FileSystemManager.C5716b;
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

/* renamed from: com.tencent.mm.vfs.RC4EncryptedFileSystem */
public class RC4EncryptedFileSystem extends FileBasedFileSystem {
    public static final Creator<RC4EncryptedFileSystem> CREATOR = new C57241();
    private final String eIq;
    private final C5716b zZG;
    private final boolean zZH;
    private volatile Key zZI;

    /* renamed from: com.tencent.mm.vfs.RC4EncryptedFileSystem$1 */
    static class C57241 implements Creator<RC4EncryptedFileSystem> {
        C57241() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RC4EncryptedFileSystem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(54570);
            RC4EncryptedFileSystem rC4EncryptedFileSystem = new RC4EncryptedFileSystem(parcel, (byte) 0);
            AppMethodBeat.m2505o(54570);
            return rC4EncryptedFileSystem;
        }
    }

    public RC4EncryptedFileSystem(String str, String str2) {
        super(str);
        AppMethodBeat.m2504i(54571);
        this.zZG = FileSystemManager.enr();
        this.eIq = str2;
        if (this.zZG == null) {
            RuntimeException runtimeException = new RuntimeException("Set global generator by calling setKeyGenerator(...) before initializing FileSystem objects.");
            AppMethodBeat.m2505o(54571);
            throw runtimeException;
        }
        this.zZI = this.zZG.mo11629e(this.eIq, Collections.unmodifiableMap(FileSystemManager.dMy().Caf));
        this.zZH = this.zZI != null;
        AppMethodBeat.m2505o(54571);
    }

    private RC4EncryptedFileSystem(Parcel parcel) {
        super(parcel);
        AppMethodBeat.m2504i(54572);
        C5736j.m8647a(parcel, getClass());
        this.zZG = FileSystemManager.enr();
        this.eIq = parcel.readString();
        if (this.zZG == null) {
            RuntimeException runtimeException = new RuntimeException("Set global generator by calling setGlobalKeyGenerator(...) before initializing FileSystem objects.");
            AppMethodBeat.m2505o(54572);
            throw runtimeException;
        }
        this.zZI = this.zZG.mo11629e(this.eIq, Collections.unmodifiableMap(FileSystemManager.dMy().Caf));
        this.zZH = this.zZI != null;
        AppMethodBeat.m2505o(54572);
    }

    public final InputStream openRead(String str) {
        AppMethodBeat.m2504i(54573);
        Key key = this.zZI;
        IOException iOException;
        if (key == null) {
            iOException = new IOException("Key is not initialized.");
            AppMethodBeat.m2505o(54573);
            throw iOException;
        }
        String O = mo11610O(str, false);
        if (O == null) {
            iOException = new IOException("Invalid path: ".concat(String.valueOf(str)));
            AppMethodBeat.m2505o(54573);
            throw iOException;
        }
        try {
            Cipher instance = Cipher.getInstance("RC4");
            instance.init(2, key);
            CipherInputStream cipherInputStream = new CipherInputStream(new FileInputStream(O), instance);
            AppMethodBeat.m2505o(54573);
            return cipherInputStream;
        } catch (GeneralSecurityException e) {
            FileNotFoundException fileNotFoundException = (FileNotFoundException) new FileNotFoundException("Failed to initialize cipher: " + e.getMessage()).initCause(e);
            AppMethodBeat.m2505o(54573);
            throw fileNotFoundException;
        }
    }

    /* renamed from: L */
    public final OutputStream mo11607L(String str, boolean z) {
        AppMethodBeat.m2504i(54574);
        Key key = this.zZI;
        IOException iOException;
        if (key == null) {
            iOException = new IOException("Key is not initialized.");
            AppMethodBeat.m2505o(54574);
            throw iOException;
        } else if (this.mReadOnly) {
            iOException = new IOException("Cannot open files for writing on read-only file systems");
            AppMethodBeat.m2505o(54574);
            throw iOException;
        } else {
            String O = mo11610O(str, true);
            if (O == null) {
                iOException = new IOException("Invalid path: ".concat(String.valueOf(str)));
                AppMethodBeat.m2505o(54574);
                throw iOException;
            }
            try {
                Cipher instance = Cipher.getInstance("RC4");
                instance.init(1, key);
                CipherOutputStream cipherOutputStream = new CipherOutputStream(new FileOutputStream(O, z), instance);
                AppMethodBeat.m2505o(54574);
                return cipherOutputStream;
            } catch (GeneralSecurityException e) {
                FileNotFoundException fileNotFoundException = (FileNotFoundException) new FileNotFoundException("Failed to initialize cipher: " + e.getMessage()).initCause(e);
                AppMethodBeat.m2505o(54574);
                throw fileNotFoundException;
            }
        }
    }

    /* renamed from: p */
    public final void mo11616p(Map<String, String> map) {
        AppMethodBeat.m2504i(54575);
        super.mo11616p(map);
        if (!this.zZH) {
            this.zZI = this.zZG.mo11629e(this.eIq, map);
        }
        AppMethodBeat.m2505o(54575);
    }

    public String toString() {
        AppMethodBeat.m2504i(54576);
        StringBuilder append = new StringBuilder("RC4FS [").append(dMt());
        if (this.mReadOnly) {
            append.append(", read-only");
        }
        String stringBuilder = append.append(']').toString();
        AppMethodBeat.m2505o(54576);
        return stringBuilder;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(54577);
        super.writeToParcel(parcel, i);
        parcel.writeInt(1);
        parcel.writeString(this.eIq);
        AppMethodBeat.m2505o(54577);
    }

    static {
        AppMethodBeat.m2504i(54578);
        AppMethodBeat.m2505o(54578);
    }
}
