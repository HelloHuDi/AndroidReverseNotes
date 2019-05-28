package com.tencent.p177mm.plugin.game.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.plugin.game.commlib.C45985a;
import com.tencent.p177mm.plugin.game.p428f.C46001c;
import com.tencent.p177mm.plugin.game.p433ui.tab.GameTabHomeUI;
import com.tencent.p177mm.plugin.game.p731d.C12111al;
import com.tencent.p177mm.plugin.game.p731d.C39197dd;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;

/* renamed from: com.tencent.mm.plugin.game.model.GameTabData */
public class GameTabData implements Parcelable {
    public static final Creator<GameTabData> CREATOR = new C32421();
    public LinkedHashMap<String, TabItem> mYm;
    public StatusBar mYn;

    /* renamed from: com.tencent.mm.plugin.game.model.GameTabData$1 */
    static class C32421 implements Creator<GameTabData> {
        C32421() {
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new GameTabData[i];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            AppMethodBeat.m2504i(111390);
            GameTabData gameTabData = new GameTabData(parcel, (byte) 0);
            AppMethodBeat.m2505o(111390);
            return gameTabData;
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.model.GameTabData$TabItem */
    public static class TabItem implements Parcelable {
        public static final Creator<TabItem> CREATOR = new C209821();
        public int cKG;
        public String jumpUrl;
        public String mVB;
        public String mYp;
        public boolean mYq;
        public boolean mYr;
        public int mYs;
        public int mYt;
        public String mYu;
        public String mYv;
        public String mYw;
        public boolean mYx;
        public int mYy;
        public String title;

        /* renamed from: com.tencent.mm.plugin.game.model.GameTabData$TabItem$1 */
        static class C209821 implements Creator<TabItem> {
            C209821() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new TabItem[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(111395);
                TabItem tabItem = new TabItem(parcel);
                AppMethodBeat.m2505o(111395);
                return tabItem;
            }
        }

        public TabItem(Parcel parcel) {
            boolean z;
            boolean z2 = true;
            AppMethodBeat.m2504i(111396);
            this.mYp = parcel.readString();
            this.title = parcel.readString();
            this.jumpUrl = parcel.readString();
            this.mYq = parcel.readByte() != (byte) 0;
            if (parcel.readByte() != (byte) 0) {
                z = true;
            } else {
                z = false;
            }
            this.mYr = z;
            this.mYs = parcel.readInt();
            this.mYt = parcel.readInt();
            this.mYu = parcel.readString();
            this.mYv = parcel.readString();
            this.mYw = parcel.readString();
            if (parcel.readByte() == (byte) 0) {
                z2 = false;
            }
            this.mYx = z2;
            this.cKG = parcel.readInt();
            this.mYy = parcel.readInt();
            this.mVB = parcel.readString();
            AppMethodBeat.m2505o(111396);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            int i2;
            int i3 = 1;
            AppMethodBeat.m2504i(111397);
            parcel.writeString(this.mYp);
            parcel.writeString(this.title);
            parcel.writeString(this.jumpUrl);
            parcel.writeByte((byte) (this.mYq ? 1 : 0));
            if (this.mYr) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            parcel.writeByte((byte) i2);
            parcel.writeInt(this.mYs);
            parcel.writeInt(this.mYt);
            parcel.writeString(this.mYu);
            parcel.writeString(this.mYv);
            parcel.writeString(this.mYw);
            if (!this.mYx) {
                i3 = 0;
            }
            parcel.writeByte((byte) i3);
            parcel.writeInt(this.cKG);
            parcel.writeInt(this.mYy);
            parcel.writeString(this.mVB);
            AppMethodBeat.m2505o(111397);
        }

        static {
            AppMethodBeat.m2504i(111398);
            AppMethodBeat.m2505o(111398);
        }
    }

    /* renamed from: com.tencent.mm.plugin.game.model.GameTabData$StatusBar */
    public static class StatusBar implements Parcelable {
        public static final Creator<StatusBar> CREATOR = new C121531();
        public int color = 0;
        public String mYo = null;

        /* renamed from: com.tencent.mm.plugin.game.model.GameTabData$StatusBar$1 */
        static class C121531 implements Creator<StatusBar> {
            C121531() {
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new StatusBar[i];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                AppMethodBeat.m2504i(111391);
                StatusBar statusBar = new StatusBar(parcel);
                AppMethodBeat.m2505o(111391);
                return statusBar;
            }
        }

        public StatusBar(Parcel parcel) {
            AppMethodBeat.m2504i(111392);
            this.mYo = parcel.readString();
            this.color = parcel.readInt();
            AppMethodBeat.m2505o(111392);
        }

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            AppMethodBeat.m2504i(111393);
            parcel.writeString(this.mYo);
            parcel.writeInt(this.color);
            AppMethodBeat.m2505o(111393);
        }

        static {
            AppMethodBeat.m2504i(111394);
            AppMethodBeat.m2505o(111394);
        }
    }

    /* synthetic */ GameTabData(Parcel parcel, byte b) {
        this(parcel);
    }

    public final List<TabItem> getItemList() {
        AppMethodBeat.m2504i(111399);
        ArrayList arrayList = new ArrayList();
        if (this.mYm != null) {
            arrayList.addAll(this.mYm.values());
        }
        AppMethodBeat.m2505o(111399);
        return arrayList;
    }

    public GameTabData() {
        AppMethodBeat.m2504i(111400);
        this.mYm = new LinkedHashMap();
        this.mYn = new StatusBar();
        AppMethodBeat.m2505o(111400);
    }

    private GameTabData(Parcel parcel) {
        AppMethodBeat.m2504i(111401);
        m85473g(parcel);
        AppMethodBeat.m2505o(111401);
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: g */
    private void m85473g(Parcel parcel) {
        AppMethodBeat.m2504i(111402);
        int readInt = parcel.readInt();
        if (this.mYm == null) {
            this.mYm = new LinkedHashMap();
        }
        for (int i = 0; i < readInt; i++) {
            TabItem tabItem = (TabItem) parcel.readParcelable(TabItem.class.getClassLoader());
            if (tabItem != null) {
                this.mYm.put(tabItem.mYp, tabItem);
            }
        }
        this.mYn = (StatusBar) parcel.readParcelable(StatusBar.class.getClassLoader());
        AppMethodBeat.m2505o(111402);
    }

    public void writeToParcel(Parcel parcel, int i) {
        AppMethodBeat.m2504i(111403);
        parcel.writeInt(this.mYm.size());
        for (Entry value : this.mYm.entrySet()) {
            parcel.writeParcelable((Parcelable) value.getValue(), i);
        }
        parcel.writeParcelable(this.mYn, i);
        AppMethodBeat.m2505o(111403);
    }

    static {
        AppMethodBeat.m2504i(111405);
        AppMethodBeat.m2505o(111405);
    }

    /* renamed from: cc */
    public static GameTabData m85472cc(List<C12111al> list) {
        AppMethodBeat.m2504i(111404);
        if (C5046bo.m7548ek(list)) {
            AppMethodBeat.m2505o(111404);
            return null;
        }
        GameTabData gameTabData = new GameTabData();
        C39197dd bDg = C45985a.bDg();
        if (bDg != null) {
            gameTabData.mYn.mYo = bDg.mYo;
            gameTabData.mYn.color = C46001c.parseColor(bDg.color);
        }
        int i = 0;
        for (C12111al c12111al : list) {
            if (!(c12111al == null || C5046bo.isNullOrNil(c12111al.naV))) {
                TabItem tabItem = new TabItem();
                tabItem.mYp = c12111al.naV;
                tabItem.title = c12111al.Title;
                tabItem.mYq = c12111al.naW;
                tabItem.mYr = c12111al.naX;
                tabItem.jumpUrl = c12111al.mZj;
                tabItem.mYu = c12111al.naY;
                tabItem.mYv = c12111al.naZ;
                if (tabItem.mYr) {
                    tabItem.mYw = GameTabHomeUI.class.getName();
                } else {
                    int i2 = i + 1;
                    i %= 3;
                    tabItem.mYw = "com.tencent.mm.plugin.game.ui.tab.GameTabWebUI" + (i != 0 ? String.valueOf(i) : "");
                    i = i2;
                }
                tabItem.mYx = false;
                tabItem.cKG = c12111al.nba;
                tabItem.mYy = c12111al.mZN;
                tabItem.mVB = c12111al.mZL;
                gameTabData.mYm.put(tabItem.mYp, tabItem);
            }
        }
        AppMethodBeat.m2505o(111404);
        return gameTabData;
    }
}
