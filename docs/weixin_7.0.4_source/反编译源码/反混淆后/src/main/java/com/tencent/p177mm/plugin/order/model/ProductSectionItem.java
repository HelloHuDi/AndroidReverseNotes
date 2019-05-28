package com.tencent.p177mm.plugin.order.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.order.model.ProductSectionItem */
public class ProductSectionItem implements Parcelable {
    public static final Creator<ProductSectionItem> CREATER = new C394801();
    public int count;
    public String iconUrl;
    public String jumpUrl;
    public String name;
    public String pdA;
    public List<Skus> pdy;
    public String pdz;
    public int scene;

    /* renamed from: com.tencent.mm.plugin.order.model.ProductSectionItem$Skus */
    public static class Skus implements Parcelable {
        public static final Creator<Skus> CREATER = new C346621();
        public String key;
        public String value;

        /* renamed from: com.tencent.mm.plugin.order.model.ProductSectionItem$Skus$1 */
        static class C346621 implements Creator<Skus> {
            C346621() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new Skus[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(43784);
                Skus skus = new Skus(parcel);
                AppMethodBeat.m2505o(43784);
                return skus;
            }
        }

        public Skus(Parcel parcel) {
            AppMethodBeat.m2504i(43785);
            this.key = parcel.readString();
            this.value = parcel.readString();
            AppMethodBeat.m2505o(43785);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(43786);
            parcel.writeString(this.key);
            parcel.writeString(this.value);
            AppMethodBeat.m2505o(43786);
        }

        static {
            AppMethodBeat.m2504i(43788);
            AppMethodBeat.m2505o(43788);
        }

        /* renamed from: ct */
        public static String m56902ct(List<Skus> list) {
            AppMethodBeat.m2504i(43787);
            String str;
            if (list == null || list.size() == 0) {
                str = "";
                AppMethodBeat.m2505o(43787);
                return str;
            }
            StringBuilder stringBuilder = new StringBuilder();
            int i = 0;
            while (true) {
                int i2 = i;
                if (i2 < list.size()) {
                    Skus skus = (Skus) list.get(i2);
                    if (i2 != 0) {
                        stringBuilder.append("、");
                    }
                    stringBuilder.append(skus.value);
                    i = i2 + 1;
                } else {
                    str = stringBuilder.toString();
                    AppMethodBeat.m2505o(43787);
                    return str;
                }
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.order.model.ProductSectionItem$1 */
    static class C394801 implements Creator<ProductSectionItem> {
        C394801() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ProductSectionItem[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(43783);
            ProductSectionItem productSectionItem = new ProductSectionItem(parcel);
            AppMethodBeat.m2505o(43783);
            return productSectionItem;
        }
    }

    public ProductSectionItem(Parcel parcel) {
        AppMethodBeat.m2504i(43789);
        this.iconUrl = parcel.readString();
        this.name = parcel.readString();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.pdy = new ArrayList();
            for (int i = 0; i < readInt; i++) {
                Skus skus = new Skus();
                skus.key = parcel.readString();
                skus.value = parcel.readString();
                this.pdy.add(skus);
            }
        }
        this.count = parcel.readInt();
        this.pdz = parcel.readString();
        this.jumpUrl = parcel.readString();
        this.pdA = parcel.readString();
        this.scene = parcel.readInt();
        AppMethodBeat.m2505o(43789);
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        AppMethodBeat.m2504i(43790);
        parcel.writeString(this.iconUrl);
        parcel.writeString(this.name);
        if (this.pdy != null) {
            parcel.writeInt(this.pdy.size());
            while (true) {
                int i3 = i2;
                if (i3 >= this.pdy.size()) {
                    break;
                }
                Skus skus = (Skus) this.pdy.get(i3);
                parcel.writeString(skus.key);
                parcel.writeString(skus.value);
                i2 = i3 + 1;
            }
        } else {
            parcel.writeInt(0);
        }
        parcel.writeInt(this.count);
        parcel.writeString(this.pdz);
        parcel.writeString(this.jumpUrl);
        parcel.writeString(this.pdA);
        parcel.writeInt(this.scene);
        AppMethodBeat.m2505o(43790);
    }

    static {
        AppMethodBeat.m2504i(43791);
        AppMethodBeat.m2505o(43791);
    }
}
