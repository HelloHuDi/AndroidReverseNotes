package com.google.android.gms.common.data;

import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.ParcelFileDescriptor.AutoCloseInputStream;
import android.os.Parcelable.Creator;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Class;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Constructor;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Field;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.Param;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable.VersionField;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedOutputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

@Class(creator = "BitmapTeleporterCreator")
public class BitmapTeleporter extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Creator<BitmapTeleporter> CREATOR = new BitmapTeleporterCreator();
    @Field(id = 3)
    private final int zzac;
    @VersionField(id = 1)
    private final int zzal;
    @Field(id = 2)
    private ParcelFileDescriptor zznb;
    private Bitmap zznc;
    private boolean zznd;
    private File zzne;

    static {
        AppMethodBeat.m2504i(61016);
        AppMethodBeat.m2505o(61016);
    }

    @Constructor
    BitmapTeleporter(@Param(id = 1) int i, @Param(id = 2) ParcelFileDescriptor parcelFileDescriptor, @Param(id = 3) int i2) {
        this.zzal = i;
        this.zznb = parcelFileDescriptor;
        this.zzac = i2;
        this.zznc = null;
        this.zznd = false;
    }

    public BitmapTeleporter(Bitmap bitmap) {
        this.zzal = 1;
        this.zznb = null;
        this.zzac = 0;
        this.zznc = bitmap;
        this.zznd = true;
    }

    private static void zza(Closeable closeable) {
        AppMethodBeat.m2504i(61015);
        try {
            closeable.close();
            AppMethodBeat.m2505o(61015);
        } catch (IOException e) {
            AppMethodBeat.m2505o(61015);
        }
    }

    private final FileOutputStream zzcj() {
        AppMethodBeat.m2504i(61014);
        IllegalStateException illegalStateException;
        if (this.zzne == null) {
            illegalStateException = new IllegalStateException("setTempDir() must be called before writing this object to a parcel");
            AppMethodBeat.m2505o(61014);
            throw illegalStateException;
        }
        try {
            File createTempFile = File.createTempFile("teleporter", ".tmp", this.zzne);
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(createTempFile);
                this.zznb = ParcelFileDescriptor.open(createTempFile, 268435456);
                createTempFile.delete();
                AppMethodBeat.m2505o(61014);
                return fileOutputStream;
            } catch (FileNotFoundException e) {
                illegalStateException = new IllegalStateException("Temporary file is somehow already deleted");
                AppMethodBeat.m2505o(61014);
                throw illegalStateException;
            }
        } catch (IOException e2) {
            IllegalStateException illegalStateException2 = new IllegalStateException("Could not create temporary file", e2);
            AppMethodBeat.m2505o(61014);
            throw illegalStateException2;
        }
    }

    public Bitmap get() {
        AppMethodBeat.m2504i(61010);
        if (!this.zznd) {
            DataInputStream dataInputStream = new DataInputStream(new AutoCloseInputStream(this.zznb));
            try {
                byte[] bArr = new byte[dataInputStream.readInt()];
                int readInt = dataInputStream.readInt();
                int readInt2 = dataInputStream.readInt();
                Config valueOf = Config.valueOf(dataInputStream.readUTF());
                dataInputStream.read(bArr);
                zza(dataInputStream);
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                Bitmap createBitmap = Bitmap.createBitmap(readInt, readInt2, valueOf);
                createBitmap.copyPixelsFromBuffer(wrap);
                this.zznc = createBitmap;
                this.zznd = true;
            } catch (IOException e) {
                IllegalStateException illegalStateException = new IllegalStateException("Could not read from parcel file descriptor", e);
                AppMethodBeat.m2505o(61010);
                throw illegalStateException;
            } catch (Throwable th) {
                zza(dataInputStream);
                AppMethodBeat.m2505o(61010);
            }
        }
        Bitmap bitmap = this.zznc;
        AppMethodBeat.m2505o(61010);
        return bitmap;
    }

    public void release() {
        AppMethodBeat.m2504i(61012);
        if (!this.zznd) {
            try {
                this.zznb.close();
                AppMethodBeat.m2505o(61012);
                return;
            } catch (IOException e) {
            }
        }
        AppMethodBeat.m2505o(61012);
    }

    public void setTempDir(File file) {
        AppMethodBeat.m2504i(61013);
        if (file == null) {
            NullPointerException nullPointerException = new NullPointerException("Cannot set null temp directory");
            AppMethodBeat.m2505o(61013);
            throw nullPointerException;
        }
        this.zzne = file;
        AppMethodBeat.m2505o(61013);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(61011);
        if (this.zznb == null) {
            Bitmap bitmap = this.zznc;
            ByteBuffer allocate = ByteBuffer.allocate(bitmap.getRowBytes() * bitmap.getHeight());
            bitmap.copyPixelsToBuffer(allocate);
            byte[] array = allocate.array();
            DataOutputStream dataOutputStream = new DataOutputStream(new BufferedOutputStream(zzcj()));
            try {
                dataOutputStream.writeInt(array.length);
                dataOutputStream.writeInt(bitmap.getWidth());
                dataOutputStream.writeInt(bitmap.getHeight());
                dataOutputStream.writeUTF(bitmap.getConfig().toString());
                dataOutputStream.write(array);
                zza(dataOutputStream);
            } catch (IOException e) {
                IllegalStateException illegalStateException = new IllegalStateException("Could not write into unlinked file", e);
                AppMethodBeat.m2505o(61011);
                throw illegalStateException;
            } catch (Throwable th) {
                zza(dataOutputStream);
                AppMethodBeat.m2505o(61011);
            }
        }
        int i2 = i | 1;
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zzal);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zznb, i2, false);
        SafeParcelWriter.writeInt(parcel, 3, this.zzac);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        this.zznb = null;
        AppMethodBeat.m2505o(61011);
    }
}
