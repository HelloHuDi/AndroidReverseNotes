package android.support.p057v4.app;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.support.p057v4.app.C6185b.C0330a;
import android.text.TextUtils;
import java.util.ArrayList;

/* renamed from: android.support.v4.app.BackStackState */
final class BackStackState implements Parcelable {
    public static final Creator<BackStackState> CREATOR = new C02921();
    /* renamed from: Ca */
    final int f209Ca;
    /* renamed from: Cb */
    final int f210Cb;
    /* renamed from: Cf */
    final int f211Cf;
    /* renamed from: Cg */
    final CharSequence f212Cg;
    /* renamed from: Ch */
    final int f213Ch;
    /* renamed from: Ci */
    final CharSequence f214Ci;
    /* renamed from: Cj */
    final ArrayList<String> f215Cj;
    /* renamed from: Ck */
    final ArrayList<String> f216Ck;
    /* renamed from: Cl */
    final boolean f217Cl;
    /* renamed from: Cs */
    final int[] f218Cs;
    final int mIndex;
    final String mName;

    /* renamed from: android.support.v4.app.BackStackState$1 */
    static class C02921 implements Creator<BackStackState> {
        C02921() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new BackStackState[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new BackStackState(parcel);
        }
    }

    public BackStackState(C6185b c6185b) {
        int size = c6185b.f1750BV.size();
        this.f218Cs = new int[(size * 6)];
        if (c6185b.f1757Cc) {
            int i = 0;
            for (int i2 = 0; i2 < size; i2++) {
                C0330a c0330a = (C0330a) c6185b.f1750BV.get(i2);
                int i3 = i + 1;
                this.f218Cs[i] = c0330a.f285Cn;
                int i4 = i3 + 1;
                this.f218Cs[i3] = c0330a.fragment != null ? c0330a.fragment.mIndex : -1;
                int i5 = i4 + 1;
                this.f218Cs[i4] = c0330a.f286Co;
                i3 = i5 + 1;
                this.f218Cs[i5] = c0330a.f287Cp;
                i5 = i3 + 1;
                this.f218Cs[i3] = c0330a.f288Cq;
                i = i5 + 1;
                this.f218Cs[i5] = c0330a.f289Cr;
            }
            this.f209Ca = c6185b.f1755Ca;
            this.f210Cb = c6185b.f1756Cb;
            this.mName = c6185b.mName;
            this.mIndex = c6185b.mIndex;
            this.f211Cf = c6185b.f1760Cf;
            this.f212Cg = c6185b.f1761Cg;
            this.f213Ch = c6185b.f1762Ch;
            this.f214Ci = c6185b.f1763Ci;
            this.f215Cj = c6185b.f1764Cj;
            this.f216Ck = c6185b.f1765Ck;
            this.f217Cl = c6185b.f1766Cl;
            return;
        }
        throw new IllegalStateException("Not on back stack");
    }

    public BackStackState(Parcel parcel) {
        this.f218Cs = parcel.createIntArray();
        this.f209Ca = parcel.readInt();
        this.f210Cb = parcel.readInt();
        this.mName = parcel.readString();
        this.mIndex = parcel.readInt();
        this.f211Cf = parcel.readInt();
        this.f212Cg = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f213Ch = parcel.readInt();
        this.f214Ci = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f215Cj = parcel.createStringArrayList();
        this.f216Ck = parcel.createStringArrayList();
        this.f217Cl = parcel.readInt() != 0;
    }

    /* renamed from: a */
    public final C6185b mo472a(FragmentManagerImpl fragmentManagerImpl) {
        C6185b c6185b = new C6185b(fragmentManagerImpl);
        int i = 0;
        int i2 = 0;
        while (i2 < this.f218Cs.length) {
            C0330a c0330a = new C0330a();
            int i3 = i2 + 1;
            c0330a.f285Cn = this.f218Cs[i2];
            if (FragmentManagerImpl.DEBUG) {
                new StringBuilder("Instantiate ").append(c6185b).append(" op #").append(i).append(" base fragment #").append(this.f218Cs[i3]);
            }
            i2 = i3 + 1;
            int i4 = this.f218Cs[i3];
            if (i4 >= 0) {
                c0330a.fragment = (Fragment) fragmentManagerImpl.mActive.get(i4);
            } else {
                c0330a.fragment = null;
            }
            i3 = i2 + 1;
            c0330a.f286Co = this.f218Cs[i2];
            i2 = i3 + 1;
            c0330a.f287Cp = this.f218Cs[i3];
            i3 = i2 + 1;
            c0330a.f288Cq = this.f218Cs[i2];
            i2 = i3 + 1;
            c0330a.f289Cr = this.f218Cs[i3];
            c6185b.f1751BW = c0330a.f286Co;
            c6185b.f1752BX = c0330a.f287Cp;
            c6185b.f1753BY = c0330a.f288Cq;
            c6185b.f1754BZ = c0330a.f289Cr;
            c6185b.mo13988a(c0330a);
            i++;
        }
        c6185b.f1755Ca = this.f209Ca;
        c6185b.f1756Cb = this.f210Cb;
        c6185b.mName = this.mName;
        c6185b.mIndex = this.mIndex;
        c6185b.f1757Cc = true;
        c6185b.f1760Cf = this.f211Cf;
        c6185b.f1761Cg = this.f212Cg;
        c6185b.f1762Ch = this.f213Ch;
        c6185b.f1763Ci = this.f214Ci;
        c6185b.f1764Cj = this.f215Cj;
        c6185b.f1765Ck = this.f216Ck;
        c6185b.f1766Cl = this.f217Cl;
        c6185b.mo13992aq(1);
        return c6185b;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeIntArray(this.f218Cs);
        parcel.writeInt(this.f209Ca);
        parcel.writeInt(this.f210Cb);
        parcel.writeString(this.mName);
        parcel.writeInt(this.mIndex);
        parcel.writeInt(this.f211Cf);
        TextUtils.writeToParcel(this.f212Cg, parcel, 0);
        parcel.writeInt(this.f213Ch);
        TextUtils.writeToParcel(this.f214Ci, parcel, 0);
        parcel.writeStringList(this.f215Cj);
        parcel.writeStringList(this.f216Ck);
        if (this.f217Cl) {
            i2 = 1;
        }
        parcel.writeInt(i2);
    }
}
