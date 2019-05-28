package com.tencent.faceBeauty;

import android.graphics.Point;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.lang.reflect.Array;

public class FaceParam implements Parcelable {
    public static final Creator<FaceParam> CREATOR = new Creator<FaceParam>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new FaceParam[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.i(86276);
            FaceParam faceParam = new FaceParam(parcel, (byte) 0);
            AppMethodBeat.o(86276);
            return faceParam;
        }
    };
    private static final String TAG = FaceParam.class.getSimpleName();
    public Rect bJk;
    public Rect bJl;
    public Rect bJm;
    public Point bJn;
    public Point bJo;
    public Rect bJp;
    public Rect bJq;
    public int[][] bJr;
    public int height;
    public int width;

    /* synthetic */ FaceParam(Parcel parcel, byte b) {
        this(parcel);
    }

    static {
        AppMethodBeat.i(86279);
        AppMethodBeat.o(86279);
    }

    public FaceParam() {
        this.width = 0;
        this.height = 0;
        this.bJk = null;
        this.bJl = null;
        this.bJm = null;
        this.bJn = null;
        this.bJo = null;
        this.bJp = null;
        this.bJq = null;
        this.bJr = null;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.i(86277);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeInt(this.bJn.x);
        parcel.writeInt(this.bJn.y);
        parcel.writeInt(this.bJo.x);
        parcel.writeInt(this.bJo.y);
        parcel.writeParcelable(this.bJk, 1);
        parcel.writeParcelable(this.bJl, 1);
        parcel.writeParcelable(this.bJm, 1);
        parcel.writeParcelable(this.bJp, 1);
        parcel.writeParcelable(this.bJq, 1);
        if (this.bJr != null) {
            parcel.writeInt(1);
            int[] iArr = new int[(this.bJr.length * 2)];
            for (int i2 = 0; i2 < this.bJr.length; i2++) {
                iArr[i2 * 2] = this.bJr[i2][0];
                iArr[(i2 * 2) + 1] = this.bJr[i2][1];
            }
            parcel.writeIntArray(iArr);
            AppMethodBeat.o(86277);
            return;
        }
        parcel.writeInt(0);
        AppMethodBeat.o(86277);
    }

    private FaceParam(Parcel parcel) {
        AppMethodBeat.i(86278);
        this.width = 0;
        this.height = 0;
        this.bJk = null;
        this.bJl = null;
        this.bJm = null;
        this.bJn = null;
        this.bJo = null;
        this.bJp = null;
        this.bJq = null;
        this.bJr = null;
        this.width = parcel.readInt();
        this.height = parcel.readInt();
        this.bJn = new Point(parcel.readInt(), parcel.readInt());
        this.bJo = new Point(parcel.readInt(), parcel.readInt());
        ClassLoader classLoader = Rect.class.getClassLoader();
        this.bJk = (Rect) parcel.readParcelable(classLoader);
        this.bJl = (Rect) parcel.readParcelable(classLoader);
        this.bJm = (Rect) parcel.readParcelable(classLoader);
        this.bJp = (Rect) parcel.readParcelable(classLoader);
        this.bJq = (Rect) parcel.readParcelable(classLoader);
        if (parcel.readInt() == 1) {
            int[] createIntArray = parcel.createIntArray();
            if (createIntArray != null && createIntArray.length >= 2) {
                this.bJr = (int[][]) Array.newInstance(Integer.TYPE, new int[]{createIntArray.length / 2, 2});
                for (int i = 0; i < createIntArray.length / 2; i++) {
                    this.bJr[i][0] = createIntArray[i * 2];
                    this.bJr[i][1] = createIntArray[(i * 2) + 1];
                }
            }
        }
        AppMethodBeat.o(86278);
    }
}
