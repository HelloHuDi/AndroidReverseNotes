package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Process;
import android.text.SpannableString;
import android.text.style.ImageSpan;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.AdapterContextMenuInfo;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.ai.f;
import com.tencent.mm.hardcoder.WXHardCoderJNI;
import com.tencent.mm.model.r;
import com.tencent.mm.platformtools.aa;
import com.tencent.mm.plugin.sns.data.SnsCmdList;
import com.tencent.mm.plugin.sns.model.af;
import com.tencent.mm.plugin.sns.model.b.b;
import com.tencent.mm.plugin.sns.model.q;
import com.tencent.mm.plugin.sns.storage.e;
import com.tencent.mm.plugin.sns.storage.j;
import com.tencent.mm.plugin.sns.storage.n;
import com.tencent.mm.plugin.sns.ui.widget.SnsAvatarImageView;
import com.tencent.mm.protocal.protobuf.ata;
import com.tencent.mm.protocal.protobuf.bau;
import com.tencent.mm.protocal.protobuf.can;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.az;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMImageView;
import com.tencent.mm.ui.base.MMSlideDelView;
import com.tencent.mm.ui.base.MMSlideDelView.c;
import com.tencent.mm.ui.base.MMSlideDelView.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.v;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class SnsMsgUI extends MMActivity implements f, b {
    private long eEO = 0;
    private int ehv;
    private long fAq = 0;
    private String fsg;
    private ak handler = af.bCo();
    private d jKa = new d() {
        public final void onMMMenuItemSelected(MenuItem menuItem, int i) {
            AppMethodBeat.i(39069);
            switch (menuItem.getItemId()) {
                case 0:
                    SnsMsgUI.a(SnsMsgUI.this, SnsMsgUI.this.rfb);
                    AppMethodBeat.o(39069);
                    return;
                case 1:
                    SnsMsgUI.n(SnsMsgUI.this);
                    AppMethodBeat.o(39069);
                    return;
                case 2:
                    SnsMsgUI.a(SnsMsgUI.this, false);
                    break;
            }
            AppMethodBeat.o(39069);
        }
    };
    private View kmS;
    private View kmT = null;
    private boolean kmU = false;
    private int[] mkD = new int[2];
    private com.tencent.matrix.trace.e.b mnM = new com.tencent.matrix.trace.e.b() {
        public final void a(String str, long j, int i) {
            AppMethodBeat.i(39075);
            super.a(str, j, i);
            if (i > 0 && !bo.isNullOrNil(str) && str.endsWith(SnsMsgUI.this.getClass().getSimpleName())) {
                SnsMsgUI.this.eEO = SnsMsgUI.this.eEO + ((long) i);
            }
            AppMethodBeat.o(39075);
        }
    };
    private ListView nDp;
    private View nDr;
    long qQp;
    int rfb;
    private an rhs;
    private SnsCmdList rjk = new SnsCmdList();
    private bd rqa;
    private a rtT;
    private boolean rtU = false;
    private boolean rtV = false;
    private boolean rtW = false;
    private p rtX;
    private OnClickListener rtY = new OnClickListener() {
        public final void onClick(View view) {
            AppMethodBeat.i(39065);
            if (view.getTag() instanceof ao) {
                SnsMsgUI.this.rhs.t(view, -1, 1);
                AppMethodBeat.o(39065);
            } else if (view.getTag() instanceof j) {
                SnsMsgUI.a(SnsMsgUI.this, (j) view.getTag());
                AppMethodBeat.o(39065);
            } else {
                ab.w("MicroMsg.SnsMsgUI", "v.getTag():" + view.getTag());
                AppMethodBeat.o(39065);
            }
        }
    };
    private com.tencent.mm.sdk.e.k.a rtZ = new com.tencent.mm.sdk.e.k.a() {
        public final void a(String str, m mVar) {
            AppMethodBeat.i(39073);
            af.bCo().post(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(39072);
                    synchronized (SnsMsgUI.this.rtT) {
                        try {
                            ab.v("MicroMsg.SnsMsgUI", "comment notify");
                            SnsMsgUI.this.rtV = true;
                            SnsMsgUI.this.rtT.a(null, null);
                        } finally {
                            while (true) {
                            }
                            AppMethodBeat.o(39072);
                        }
                    }
                }
            });
            AppMethodBeat.o(39073);
        }
    };
    Runnable rua = new Runnable() {
        public final void run() {
            AppMethodBeat.i(39074);
            if (SnsMsgUI.this.rtT == null) {
                AppMethodBeat.o(39074);
                return;
            }
            synchronized (SnsMsgUI.this.rtT) {
                try {
                    SnsMsgUI.this.rtT.a(null, null);
                    SnsMsgUI.this.rtU = false;
                } finally {
                    while (true) {
                    }
                    AppMethodBeat.o(39074);
                }
            }
        }
    };

    class a extends com.tencent.mm.ui.p<j> {
        int enb = this.kmW;
        protected g jJO;
        protected c jJP;
        protected MMSlideDelView.d jJR = new MMSlideDelView.d() {
            public final void a(MMSlideDelView mMSlideDelView, boolean z) {
                AppMethodBeat.i(39084);
                if (z) {
                    nDv.add(mMSlideDelView);
                    AppMethodBeat.o(39084);
                    return;
                }
                nDv.remove(mMSlideDelView);
                AppMethodBeat.o(39084);
            }

            public final boolean bIo() {
                AppMethodBeat.i(39085);
                if (nDv.size() > 0) {
                    AppMethodBeat.o(39085);
                    return true;
                }
                AppMethodBeat.o(39085);
                return false;
            }

            public final void bIp() {
                AppMethodBeat.i(39086);
                for (MMSlideDelView mMSlideDelView : nDv) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.dzZ();
                    }
                }
                nDv.clear();
                AppMethodBeat.o(39086);
            }

            public final void bIq() {
                AppMethodBeat.i(39087);
                for (MMSlideDelView mMSlideDelView : nDv) {
                    if (mMSlideDelView != null) {
                        mMSlideDelView.dzY();
                    }
                }
                nDv.clear();
                AppMethodBeat.o(39087);
            }
        };
        int kmW = 10;
        private Set<MMSlideDelView> nDv = new HashSet();
        protected MMSlideDelView.f ruf;

        class a {
            long cND;
            View jJW;
            TextView jJX;
            TextView pnE;
            SnsAvatarImageView ruh;
            TextView rui;
            ImageView ruj;
            TextView ruk;
            MMImageView rul;
            ImageView rum;
            TextView timeTv;

            a() {
            }
        }

        public a(Context context, j jVar) {
            super(context, jVar);
            AppMethodBeat.i(39090);
            AppMethodBeat.o(39090);
        }

        public final long getItemId(int i) {
            AppMethodBeat.i(39091);
            long j = ((j) getItem(i)).field_snsID;
            AppMethodBeat.o(39091);
            return j;
        }

        public final void KD() {
            AppMethodBeat.i(39092);
            bIf();
            KC();
            AppMethodBeat.o(39092);
        }

        public final void setPerformItemClickListener(g gVar) {
            this.jJO = gVar;
        }

        public final void b(MMSlideDelView.f fVar) {
            this.ruf = fVar;
        }

        public final void setGetViewPositionCallback(c cVar) {
            this.jJP = cVar;
        }

        public final synchronized void a(String str, m mVar) {
            AppMethodBeat.i(39093);
            super.a(str, mVar);
            AppMethodBeat.o(39093);
        }

        public final void KC() {
            AppMethodBeat.i(39094);
            if (af.cnK().baS() <= 0 || SnsMsgUI.this.rtV) {
                this.enb = af.cnK().cqG();
                setCursor(af.cnK().DH(this.kmW));
            } else {
                setCursor(af.cnK().cqF());
            }
            notifyDataSetChanged();
            AppMethodBeat.o(39094);
        }

        public final boolean bdn() {
            return this.kmW >= this.enb;
        }

        public final int bdo() {
            AppMethodBeat.i(39095);
            if (bdn()) {
                if (SnsMsgUI.this.kmT.getParent() != null) {
                    SnsMsgUI.this.nDp.removeFooterView(SnsMsgUI.this.kmT);
                }
                AppMethodBeat.o(39095);
                return 0;
            }
            this.kmW += 10;
            if (this.kmW <= this.enb) {
                AppMethodBeat.o(39095);
                return 10;
            }
            this.kmW = this.enb;
            int i = this.enb % 10;
            AppMethodBeat.o(39095);
            return i;
        }

        /* JADX WARNING: Removed duplicated region for block: B:87:0x032e A:{SYNTHETIC, Splitter:B:87:0x032e} */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0140 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x0339 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x018d A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x01d5 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0362 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x035f A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0365 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:97:0x0368 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x03b1 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x01f5 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x03b4 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x01f8 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0248 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:189:0x0868 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x0273 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:205:0x08d5  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x02ce  */
        /* JADX WARNING: Removed duplicated region for block: B:206:0x08d9  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x02e0  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0140 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x032e A:{SYNTHETIC, Splitter:B:87:0x032e} */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x018d A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x0339 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x01b0 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x01d5 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0362 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x035f A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0365 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:97:0x0368 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x01d8 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x01f5 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x03b1 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x01f8 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x03b4 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x0230 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0248 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x0273 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:189:0x0868 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x02ba  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x02ce  */
        /* JADX WARNING: Removed duplicated region for block: B:205:0x08d5  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x02e0  */
        /* JADX WARNING: Removed duplicated region for block: B:206:0x08d9  */
        /* JADX WARNING: Removed duplicated region for block: B:87:0x032e A:{SYNTHETIC, Splitter:B:87:0x032e} */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0140 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:89:0x0339 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x018d A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x01b0 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x01d5 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0362 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:94:0x035f A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:96:0x0365 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:97:0x0368 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x01d8 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:105:0x03b1 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x01f5 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:106:0x03b4 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x01f8 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:46:0x0230 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0248 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:189:0x0868 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x0273 A:{Catch:{ Exception -> 0x0320 }} */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x02ba  */
        /* JADX WARNING: Removed duplicated region for block: B:205:0x08d5  */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x02ce  */
        /* JADX WARNING: Removed duplicated region for block: B:206:0x08d9  */
        /* JADX WARNING: Removed duplicated region for block: B:69:0x02e0  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            AppMethodBeat.i(39096);
            j jVar = (j) getItem(i);
            if (view == null || !(view.getTag() instanceof a)) {
                View view2 = (MMSlideDelView) v.hu(this.context).inflate(R.layout.g8, null);
                View inflate = v.hu(this.context).inflate(R.layout.avt, null);
                a aVar2 = new a();
                aVar2.ruh = (SnsAvatarImageView) inflate.findViewById(R.id.ek4);
                aVar2.ruh.setWeakContext(this.context);
                aVar2.pnE = (TextView) inflate.findViewById(R.id.ek5);
                aVar2.ruk = (TextView) inflate.findViewById(R.id.ek7);
                aVar2.ruj = (ImageView) inflate.findViewById(R.id.ek6);
                aVar2.timeTv = (TextView) inflate.findViewById(R.id.ek8);
                aVar2.rul = (MMImageView) inflate.findViewById(R.id.eka);
                aVar2.rui = (TextView) inflate.findViewById(R.id.ekc);
                aVar2.rul.setOnClickListener(SnsMsgUI.this.rtY);
                aVar2.jJW = view2.findViewById(R.id.a4b);
                aVar2.jJX = (TextView) view2.findViewById(R.id.nu);
                aVar2.rum = (ImageView) inflate.findViewById(R.id.ekb);
                view2.setView(inflate);
                view2.setPerformItemClickListener(this.jJO);
                view2.setGetViewPositionCallback(this.jJP);
                view2.setItemStatusCallBack(this.jJR);
                view2.setEnable(false);
                view2.setTag(aVar2);
                aVar = aVar2;
                view = view2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.rul.setTag(null);
            aVar.cND = jVar.field_snsID;
            aVar.jJW.setTag(Integer.valueOf(jVar.rfb));
            aVar.jJW.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(39088);
                    ab.v("MicroMsg.SnsMsgUI", "on delView clicked");
                    a.this.jJR.bIq();
                    if (a.this.ruf != null) {
                        a.this.ruf.bN(view.getTag());
                    }
                    AppMethodBeat.o(39088);
                }
            });
            String str = "";
            can can = (can) new can().parseFrom(jVar.field_curActionBuf);
            String str2;
            final String str3;
            ad aoO;
            CharSequence Oj;
            n kD;
            TextView textView;
            int i2;
            Object obj;
            TextView textView2;
            e ku;
            n nVar;
            Object obj2;
            try {
                str2 = ((can) new can().parseFrom(jVar.field_refActionBuf)).wPm;
                try {
                    if (bo.isNullOrNil(str2) || str2.equals(af.cnk())) {
                        str = "";
                        try {
                            if (bo.isNullOrNil(can.wPm)) {
                                com.tencent.mm.pluginsdk.ui.a.b.b(aVar.ruh, can.wPm);
                                str3 = can.wPm;
                                aVar.ruh.dk(str3, 6);
                                if (bo.isEqual(SnsMsgUI.this.fsg, str3)) {
                                    aVar.ruh.setShowStoryHint(false);
                                } else {
                                    SnsAvatarImageView snsAvatarImageView = aVar.ruh;
                                    com.tencent.mm.kernel.g.RQ();
                                    snsAvatarImageView.setShowStoryHint(((com.tencent.mm.plugin.story.api.e) com.tencent.mm.kernel.g.M(com.tencent.mm.plugin.story.api.e.class)).hasNewStory(str3));
                                }
                                aVar.ruh.setOnClickListener(new OnClickListener() {
                                    public final void onClick(View view) {
                                        AppMethodBeat.i(39089);
                                        Intent intent = new Intent();
                                        intent.putExtra("Contact_User", str3);
                                        intent.putExtra("CONTACT_INFO_UI_SOURCE", 11);
                                        com.tencent.mm.plugin.sns.c.a.gkE.c(intent, SnsMsgUI.this);
                                        SnsMsgUI.t(SnsMsgUI.this);
                                        AppMethodBeat.o(39089);
                                    }
                                });
                            } else {
                                ab.e("MicroMsg.SnsMsgUI", "action.getFromUsername() is null or Nil");
                            }
                            aoO = SnsMsgUI.this.rqa.aoO(can.wPm);
                            if (aoO == null) {
                                Oj = aoO.Oj();
                            } else if (bo.isNullOrNil(can.wZD)) {
                                Oj = can.wPm;
                            } else {
                                Oj = can.wZD;
                            }
                            aVar.pnE.setText(com.tencent.mm.pluginsdk.ui.e.j.b(SnsMsgUI.this, Oj, aVar.pnE.getTextSize()));
                            kD = af.cnF().kD(jVar.field_snsID);
                            if (kD == null && kD.field_type == 21) {
                                aVar.pnE.setTextColor(SnsMsgUI.this.getResources().getColor(R.color.a0s));
                            } else {
                                aVar.pnE.setTextColor(SnsMsgUI.this.getResources().getColor(R.color.a0k));
                            }
                            str3 = can.wPm;
                            textView = aVar.pnE;
                            i2 = can.vFH;
                            switch (jVar.field_type) {
                                case 1:
                                case 2:
                                    obj = null;
                                    break;
                                case 3:
                                case 5:
                                    obj = 1;
                                    break;
                                case 4:
                                    obj = null;
                                    break;
                                case 7:
                                case 8:
                                case 13:
                                case 14:
                                case 16:
                                    obj = null;
                                    break;
                                default:
                                    obj = 1;
                                    break;
                            }
                            if (obj != null || SnsMsgUI.this.fsg.equals(str3)) {
                                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                            } else {
                                Drawable g;
                                switch (i2) {
                                    case 18:
                                        g = com.tencent.mm.bz.a.g(this.context, R.drawable.al5);
                                        break;
                                    case 22:
                                    case 23:
                                    case 24:
                                    case 26:
                                    case 27:
                                    case com.tencent.view.d.MIC_BASE_CHANNELSHARPEN /*28*/:
                                    case 29:
                                        g = com.tencent.mm.bz.a.g(this.context, R.drawable.al7);
                                        break;
                                    case 25:
                                        g = com.tencent.mm.bz.a.g(this.context, R.drawable.al3);
                                        break;
                                    case 30:
                                        g = com.tencent.mm.bz.a.g(this.context, R.drawable.al4);
                                        break;
                                    default:
                                        g = com.tencent.mm.bz.a.g(this.context, R.drawable.al6);
                                        break;
                                }
                                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, g, null);
                            }
                            textView2 = aVar.ruk;
                            if ((jVar.field_commentflag & 1) <= 0) {
                                obj = 1;
                            } else {
                                obj = null;
                            }
                            if (obj != null) {
                                textView2.setTextColor(SnsMsgUI.this.getResources().getColor(R.color.h4));
                                textView2.setBackgroundDrawable(null);
                                textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                                textView2.setText("");
                                textView2.setCompoundDrawablePadding(0);
                                Drawable g2;
                                SpannableString spannableString;
                                String str4;
                                e ku2;
                                switch (can.jCt) {
                                    case 1:
                                    case 5:
                                        kD = af.cnF().kD(jVar.field_snsID);
                                        if (kD != null && kD.field_type == 7) {
                                            textView2.setText(SnsMsgUI.this.getString(R.string.em6));
                                            break;
                                        }
                                        g2 = com.tencent.mm.bz.a.g(this.context, R.raw.friendactivity_likeicon);
                                        if (kD == null || kD.field_type != 21) {
                                            g2.clearColorFilter();
                                        } else {
                                            g2.setColorFilter(SnsMsgUI.this.getResources().getColor(R.color.a0w), Mode.SRC_ATOP);
                                        }
                                        g2.setBounds(0, 0, g2.getIntrinsicWidth(), g2.getIntrinsicHeight());
                                        spannableString = new SpannableString(" ");
                                        spannableString.setSpan(new ImageSpan(g2), 0, 1, 18);
                                        textView2.setText(spannableString);
                                        textView2.setContentDescription(SnsMsgUI.this.mController.ylL.getString(R.string.eks));
                                        break;
                                    case 2:
                                    case 3:
                                        str4 = can.ncM;
                                        str2 = "";
                                        ku2 = af.cnI().ku(jVar.field_snsID);
                                        if (com.tencent.mm.plugin.sns.ui.widget.d.fF(can.wZL, 1)) {
                                            if (ku2 != null) {
                                                com.tencent.mm.kernel.g.RQ();
                                                aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoM(ku2.field_userName);
                                                str2 = this.context.getString(R.string.en1, new Object[]{aoO.Oj()});
                                            }
                                        } else if (!bo.isNullOrNil(str)) {
                                            str2 = this.context.getString(R.string.en2, new Object[]{str});
                                        }
                                        textView2.setText(com.tencent.mm.pluginsdk.ui.e.j.b(SnsMsgUI.this, str2 + str4 + " ", textView2.getTextSize()));
                                        break;
                                    case 4:
                                        textView2.setText(SnsMsgUI.this.getString(R.string.eq3));
                                        break;
                                    case 7:
                                        textView2.setCompoundDrawablesWithIntrinsicBounds(com.tencent.mm.bz.a.g(this.context, R.raw.friendactivity_likeicon), null, null, null);
                                        textView2.setContentDescription(SnsMsgUI.this.mController.ylL.getString(R.string.eks));
                                        break;
                                    case 8:
                                        str2 = "";
                                        str4 = bo.nullAsNil(can.ncM);
                                        ku2 = af.cnI().ku(jVar.field_snsID);
                                        if (com.tencent.mm.plugin.sns.ui.widget.d.fF(can.wZL, 1)) {
                                            if (ku2 != null) {
                                                com.tencent.mm.kernel.g.RQ();
                                                aoO = ((com.tencent.mm.plugin.messenger.foundation.a.j) com.tencent.mm.kernel.g.K(com.tencent.mm.plugin.messenger.foundation.a.j.class)).XM().aoM(ku2.field_userName);
                                                str2 = this.context.getString(R.string.en1, new Object[]{aoO.Oj()});
                                            }
                                        } else if (!bo.isNullOrNil(str)) {
                                            str2 = this.context.getString(R.string.en2, new Object[]{str});
                                        }
                                        textView2.setText(com.tencent.mm.pluginsdk.ui.e.j.b(SnsMsgUI.this, str2 + str4 + " ", textView2.getTextSize()));
                                        break;
                                    case 13:
                                        ata ata = new ata();
                                        ab.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + can.wZK);
                                        try {
                                            ata.parseFrom(aa.a(can.wZK));
                                            ab.i("MicroMsg.SnsMsgUI", "hbbuffer  " + ata.cSh);
                                        } catch (Exception e) {
                                            ab.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + e.getMessage());
                                        }
                                        SnsMsgUI.this.rqa.aoO(can.wPm);
                                        g2 = null;
                                        if (ata.cSh == 0) {
                                            SnsMsgUI.this.rtW = true;
                                            spannableString = new SpannableString(SnsMsgUI.this.getString(R.string.cpo));
                                        } else {
                                            SnsMsgUI.this.rtW = false;
                                            spannableString = new SpannableString(" " + SnsMsgUI.this.getString(R.string.cpn, new Object[]{bo.F(((double) ata.cSh) / 100.0d)}));
                                            g2 = SnsMsgUI.this.getResources().getDrawable(R.drawable.b5);
                                        }
                                        if (g2 != null) {
                                            g2.setBounds(0, 0, g2.getIntrinsicWidth(), g2.getIntrinsicHeight());
                                            com.tencent.mm.ui.widget.a aVar3 = new com.tencent.mm.ui.widget.a(g2);
                                            aVar3.zLT = (int) (((((float) g2.getIntrinsicHeight()) - textView2.getTextSize()) + ((float) com.tencent.mm.bz.a.fromDPToPix(SnsMsgUI.this, 2))) / 2.0f);
                                            spannableString.setSpan(aVar3, 0, 1, 33);
                                        }
                                        textView2.setText(spannableString);
                                        break;
                                    case 14:
                                        ata ata2 = new ata();
                                        ab.i("MicroMsg.SnsMsgUI", "curAction.HBBuffer " + can.wZK);
                                        try {
                                            ata2.parseFrom(aa.a(can.wZK));
                                            ab.i("MicroMsg.SnsMsgUI", "hbbuffer  " + ata2.cSh);
                                        } catch (Exception e2) {
                                            ab.e("MicroMsg.SnsMsgUI", "parser hbbuffer " + e2.getMessage());
                                        }
                                        aoO = SnsMsgUI.this.rqa.aoO(can.wPm);
                                        textView2.setText(SnsMsgUI.this.getString(R.string.cpl, new Object[]{aoO.Oj(), bo.F(((double) ata2.cSh) / 100.0d)}));
                                        break;
                                    case 16:
                                        textView2.setText(com.tencent.mm.pluginsdk.ui.e.j.b(SnsMsgUI.this, ("" + "[" + SnsMsgUI.this.getString(R.string.eix) + "]") + " " + bo.nullAsNil(can.ncM), textView2.getTextSize()));
                                        break;
                                    default:
                                        break;
                                }
                            }
                            textView2.setText(R.string.emx);
                            textView2.setBackgroundColor(SnsMsgUI.this.getResources().getColor(R.color.l2));
                            textView2.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                            aVar.timeTv.setText(aw.l(SnsMsgUI.this, ((long) can.pcX) * 1000));
                            kD = null;
                            if (can.jCt != 7 || can.jCt == 8 || can.jCt == 16) {
                                ku = af.cnI().ku(jVar.field_snsID);
                                if (ku != null) {
                                    kD = ku.cqB();
                                }
                                nVar = kD;
                            } else {
                                nVar = af.cnF().kD(jVar.field_snsID);
                            }
                            aVar.rul.setVisibility(8);
                            aVar.rui.setVisibility(8);
                            aVar.rum.setVisibility(8);
                            aVar.rul.setImageBitmap(null);
                            af.cnC().dB(aVar.rul);
                            if (nVar == null) {
                                LinkedList linkedList = nVar.cqu().xfI.wbK;
                                if (nVar.field_type == 2) {
                                    aVar.rul.setTag(null);
                                    aVar.rui.setVisibility(0);
                                    aVar.rui.setText(com.tencent.mm.pluginsdk.ui.e.j.b(SnsMsgUI.this, nVar.cqu().xfF, aVar.rui.getTextSize()));
                                } else {
                                    int i3;
                                    MMImageView mMImageView;
                                    obj2 = null;
                                    if (linkedList.size() > 0) {
                                        i3 = nVar.field_type;
                                        mMImageView = aVar.rul;
                                        int i4 = -1;
                                        switch (i3) {
                                            case 1:
                                                i4 = R.drawable.avp;
                                                break;
                                            case 2:
                                                mMImageView.setImageDrawable(null);
                                                break;
                                            case 3:
                                                i4 = R.raw.app_attach_file_icon_webpage;
                                                break;
                                            case 4:
                                                i4 = R.raw.app_attach_file_icon_music;
                                                break;
                                            case 5:
                                            case 15:
                                                i4 = R.raw.app_attach_file_icon_video;
                                                break;
                                            case 6:
                                                i4 = R.raw.app_attach_file_icon_location;
                                                break;
                                            case 7:
                                                i4 = R.drawable.avp;
                                                break;
                                            case 8:
                                                mMImageView.setImageDrawable(null);
                                                break;
                                            default:
                                                i4 = R.raw.app_attach_file_icon_webpage;
                                                break;
                                        }
                                        af.cnC().a((bau) linkedList.get(0), aVar.rul, i4, SnsMsgUI.this.hashCode(), az.xYS);
                                        if (nVar.field_type == 15 || (nVar.field_type == 27 && linkedList.size() > 0 && ((bau) linkedList.get(0)).jCt == 6)) {
                                            aVar.rum.setVisibility(0);
                                            j jVar2 = new j();
                                            af.cnK().b(jVar.xDa, (com.tencent.mm.sdk.e.c) jVar2);
                                            aVar.rul.setTag(jVar2);
                                            obj2 = 1;
                                        } else {
                                            ao aoVar = new ao();
                                            aoVar.czD = nVar.cqU();
                                            aoVar.index = 0;
                                            ArrayList arrayList = new ArrayList();
                                            arrayList.add(aVar.rul);
                                            aoVar.rsl = arrayList;
                                            aoVar.position = i;
                                            aVar.rul.setTag(aoVar);
                                            i3 = 1;
                                        }
                                    }
                                    mMImageView = aVar.rul;
                                    if (obj2 != null) {
                                        i3 = 0;
                                    } else {
                                        i3 = 8;
                                    }
                                    mMImageView.setVisibility(i3);
                                }
                            } else if (!(can.jCt == 7 || can.jCt == 8)) {
                                if (can.jCt == 16) {
                                    if (com.tencent.mm.plugin.sns.model.m.kc(jVar.field_snsID)) {
                                        if (can.vFa != null) {
                                            ab.i("MicroMsg.SnsMsgUI", "atFriend detail, aid %d", Integer.valueOf(can.vFa.wTz));
                                        }
                                        com.tencent.mm.ai.m mVar = new com.tencent.mm.plugin.sns.model.m(jVar.field_snsID, can.vFa);
                                        com.tencent.mm.kernel.g.RQ();
                                        com.tencent.mm.kernel.g.RO().eJo.a(mVar, 0);
                                    }
                                } else if (q.kf(jVar.field_snsID)) {
                                    com.tencent.mm.kernel.g.RQ();
                                    com.tencent.mm.kernel.g.RO().eJo.a(new q(jVar.field_snsID), 0);
                                }
                            }
                        } catch (Exception e3) {
                            ab.printErrStackTrace("MicroMsg.SnsMsgUI", e3, "", new Object[0]);
                        }
                        obj2 = (aVar.rul.getVisibility() != 0 || aVar.rum.getVisibility() == 0) ? 1 : null;
                        view.findViewById(R.id.ek_).setVisibility(obj2 == null ? 0 : 8);
                        view.findViewById(R.id.ek9).setVisibility(jVar.field_isSilence != 1 ? 0 : 8);
                        AppMethodBeat.o(39096);
                        return view;
                    }
                    ad aoO2 = SnsMsgUI.this.rqa.aoO(str2);
                    if (!(aoO2 == null || bo.isNullOrNil(aoO2.Oj()))) {
                        str2 = aoO2.Oj();
                    }
                    str = str2;
                    if (bo.isNullOrNil(can.wPm)) {
                    }
                    aoO = SnsMsgUI.this.rqa.aoO(can.wPm);
                    if (aoO == null) {
                    }
                    aVar.pnE.setText(com.tencent.mm.pluginsdk.ui.e.j.b(SnsMsgUI.this, Oj, aVar.pnE.getTextSize()));
                    kD = af.cnF().kD(jVar.field_snsID);
                    if (kD == null) {
                    }
                    aVar.pnE.setTextColor(SnsMsgUI.this.getResources().getColor(R.color.a0k));
                    str3 = can.wPm;
                    textView = aVar.pnE;
                    i2 = can.vFH;
                    switch (jVar.field_type) {
                        case 1:
                        case 2:
                            break;
                        case 3:
                        case 5:
                            break;
                        case 4:
                            break;
                        case 7:
                        case 8:
                        case 13:
                        case 14:
                        case 16:
                            break;
                        default:
                            break;
                    }
                    if (obj != null) {
                    }
                    textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    textView2 = aVar.ruk;
                    if ((jVar.field_commentflag & 1) <= 0) {
                    }
                    if (obj != null) {
                    }
                    aVar.timeTv.setText(aw.l(SnsMsgUI.this, ((long) can.pcX) * 1000));
                    kD = null;
                    if (can.jCt != 7) {
                    }
                    ku = af.cnI().ku(jVar.field_snsID);
                    if (ku != null) {
                    }
                    nVar = kD;
                    aVar.rul.setVisibility(8);
                    aVar.rui.setVisibility(8);
                    aVar.rum.setVisibility(8);
                    aVar.rul.setImageBitmap(null);
                    af.cnC().dB(aVar.rul);
                    if (nVar == null) {
                    }
                    if (aVar.rul.getVisibility() != 0) {
                    }
                    if (obj2 == null) {
                    }
                    view.findViewById(R.id.ek_).setVisibility(obj2 == null ? 0 : 8);
                    if (jVar.field_isSilence != 1) {
                    }
                    view.findViewById(R.id.ek9).setVisibility(jVar.field_isSilence != 1 ? 0 : 8);
                    AppMethodBeat.o(39096);
                    return view;
                } catch (Exception e4) {
                    str = str2;
                    if (bo.isNullOrNil(can.wPm)) {
                    }
                    aoO = SnsMsgUI.this.rqa.aoO(can.wPm);
                    if (aoO == null) {
                    }
                    aVar.pnE.setText(com.tencent.mm.pluginsdk.ui.e.j.b(SnsMsgUI.this, Oj, aVar.pnE.getTextSize()));
                    kD = af.cnF().kD(jVar.field_snsID);
                    if (kD == null) {
                    }
                    aVar.pnE.setTextColor(SnsMsgUI.this.getResources().getColor(R.color.a0k));
                    str3 = can.wPm;
                    textView = aVar.pnE;
                    i2 = can.vFH;
                    switch (jVar.field_type) {
                        case 1:
                        case 2:
                            break;
                        case 3:
                        case 5:
                            break;
                        case 4:
                            break;
                        case 7:
                        case 8:
                        case 13:
                        case 14:
                        case 16:
                            break;
                        default:
                            break;
                    }
                    if (obj != null) {
                    }
                    textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                    textView2 = aVar.ruk;
                    if ((jVar.field_commentflag & 1) <= 0) {
                    }
                    if (obj != null) {
                    }
                    aVar.timeTv.setText(aw.l(SnsMsgUI.this, ((long) can.pcX) * 1000));
                    kD = null;
                    if (can.jCt != 7) {
                    }
                    ku = af.cnI().ku(jVar.field_snsID);
                    if (ku != null) {
                    }
                    nVar = kD;
                    aVar.rul.setVisibility(8);
                    aVar.rui.setVisibility(8);
                    aVar.rum.setVisibility(8);
                    aVar.rul.setImageBitmap(null);
                    af.cnC().dB(aVar.rul);
                    if (nVar == null) {
                    }
                    if (aVar.rul.getVisibility() != 0) {
                    }
                    if (obj2 == null) {
                    }
                    view.findViewById(R.id.ek_).setVisibility(obj2 == null ? 0 : 8);
                    if (jVar.field_isSilence != 1) {
                    }
                    view.findViewById(R.id.ek9).setVisibility(jVar.field_isSilence != 1 ? 0 : 8);
                    AppMethodBeat.o(39096);
                    return view;
                }
            } catch (Exception e5) {
                str2 = str;
                str = str2;
                if (bo.isNullOrNil(can.wPm)) {
                }
                aoO = SnsMsgUI.this.rqa.aoO(can.wPm);
                if (aoO == null) {
                }
                aVar.pnE.setText(com.tencent.mm.pluginsdk.ui.e.j.b(SnsMsgUI.this, Oj, aVar.pnE.getTextSize()));
                kD = af.cnF().kD(jVar.field_snsID);
                if (kD == null) {
                }
                aVar.pnE.setTextColor(SnsMsgUI.this.getResources().getColor(R.color.a0k));
                str3 = can.wPm;
                textView = aVar.pnE;
                i2 = can.vFH;
                switch (jVar.field_type) {
                    case 1:
                    case 2:
                        break;
                    case 3:
                    case 5:
                        break;
                    case 4:
                        break;
                    case 7:
                    case 8:
                    case 13:
                    case 14:
                    case 16:
                        break;
                    default:
                        break;
                }
                if (obj != null) {
                }
                textView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
                textView2 = aVar.ruk;
                if ((jVar.field_commentflag & 1) <= 0) {
                }
                if (obj != null) {
                }
                aVar.timeTv.setText(aw.l(SnsMsgUI.this, ((long) can.pcX) * 1000));
                kD = null;
                if (can.jCt != 7) {
                }
                ku = af.cnI().ku(jVar.field_snsID);
                if (ku != null) {
                }
                nVar = kD;
                aVar.rul.setVisibility(8);
                aVar.rui.setVisibility(8);
                aVar.rum.setVisibility(8);
                aVar.rul.setImageBitmap(null);
                af.cnC().dB(aVar.rul);
                if (nVar == null) {
                }
                if (aVar.rul.getVisibility() != 0) {
                }
                if (obj2 == null) {
                }
                view.findViewById(R.id.ek_).setVisibility(obj2 == null ? 0 : 8);
                if (jVar.field_isSilence != 1) {
                }
                view.findViewById(R.id.ek9).setVisibility(jVar.field_isSilence != 1 ? 0 : 8);
                AppMethodBeat.o(39096);
                return view;
            }
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SnsMsgUI() {
        AppMethodBeat.i(39098);
        AppMethodBeat.o(39098);
    }

    static /* synthetic */ void t(SnsMsgUI snsMsgUI) {
        AppMethodBeat.i(39114);
        snsMsgUI.ctD();
        AppMethodBeat.o(39114);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(39099);
        super.onCreate(bundle);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(210, (f) this);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(683, (f) this);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.a(218, (f) this);
        this.fsg = r.Yz();
        this.rqa = af.cnt();
        this.rtV = getIntent().getBooleanExtra("sns_msg_force_show_all", false);
        if (this.rtV) {
            this.kmU = true;
        }
        af.cnK().c(this.rtZ);
        xE(this.mController.dyj());
        initView();
        AppMethodBeat.o(39099);
    }

    public void onDestroy() {
        AppMethodBeat.i(39100);
        ab.d("MicroMsg.SnsMsgUI", "msgui onDestroy");
        af.cnK().baT();
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(210, (f) this);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(683, (f) this);
        com.tencent.mm.kernel.g.RQ();
        com.tencent.mm.kernel.g.RO().eJo.b(218, (f) this);
        af.cnK().d(this.rtZ);
        this.rtT.bIf();
        af.cnC().ab(this);
        if (this.rtX != null) {
            this.rtX.dismiss();
            this.rtX = null;
        }
        super.onDestroy();
        AppMethodBeat.o(39100);
    }

    public void onResume() {
        AppMethodBeat.i(39101);
        this.fAq = bo.anT();
        if (com.tencent.matrix.a.isInstalled() && com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class) != null) {
            com.tencent.matrix.trace.f.c cVar = ((com.tencent.matrix.trace.a) com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class)).bYx;
            if (cVar != null) {
                cVar.a(this.mnM);
            }
        }
        af.cnA().a((b) this);
        super.onResume();
        AppMethodBeat.o(39101);
    }

    public void onPause() {
        AppMethodBeat.i(39102);
        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSMsgScrollEnable, this.ehv);
        this.ehv = 0;
        af.cnA().b((b) this);
        super.onPause();
        if (com.tencent.matrix.a.isInstalled() && com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class) != null) {
            com.tencent.matrix.trace.f.c cVar = ((com.tencent.matrix.trace.a) com.tencent.matrix.a.yK().F(com.tencent.matrix.trace.a.class)).bYx;
            if (cVar != null) {
                cVar.b(this.mnM);
            }
        }
        this.fAq = bo.anT() > this.fAq ? bo.anT() - this.fAq : 1;
        WXHardCoderJNI.reportFPS(705, WXHardCoderJNI.hcSNSMsgScrollAction, 1, this.eEO, this.fAq);
        this.eEO = 0;
        this.fAq = 0;
        AppMethodBeat.o(39102);
    }

    public final int getLayoutId() {
        return R.layout.avu;
    }

    public final void initView() {
        AppMethodBeat.i(39103);
        setMMTitle((int) R.string.en3);
        addTextOptionMenu(0, getString(R.string.ou), new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39077);
                h.a(SnsMsgUI.this.mController.ylL, SnsMsgUI.this.getString(R.string.emw), "", new DialogInterface.OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        AppMethodBeat.i(39076);
                        SnsMsgUI.this.nDp.setVisibility(8);
                        SnsMsgUI.this.nDr.setVisibility(0);
                        af.cnK().fni.hY("SnsComment", "delete from SnsComment");
                        SnsMsgUI.this.enableOptionMenu(false);
                        AppMethodBeat.o(39076);
                    }
                }, null);
                AppMethodBeat.o(39077);
                return true;
            }
        });
        this.rhs = new an(this);
        this.nDr = findViewById(R.id.eke);
        this.nDp = (ListView) findViewById(R.id.ekd);
        this.kmS = v.hu(this).inflate(R.layout.avs, null);
        this.kmT = v.hu(this).inflate(R.layout.adp, null);
        ab.d("MicroMsg.SnsMsgUI", "autoLoad " + this.kmU);
        if (this.kmU) {
            this.nDp.addFooterView(this.kmT);
        } else {
            this.nDp.addFooterView(this.kmS);
        }
        this.rtT = new a(this, new j());
        this.rtT.setGetViewPositionCallback(new c() {
            public final int cZ(View view) {
                AppMethodBeat.i(39078);
                int positionForView = SnsMsgUI.this.nDp.getPositionForView(view);
                AppMethodBeat.o(39078);
                return positionForView;
            }
        });
        this.rtT.setPerformItemClickListener(new g() {
            public final void q(View view, int i, int i2) {
                AppMethodBeat.i(39079);
                SnsMsgUI.this.nDp.performItemClick(view, i, (long) i2);
                AppMethodBeat.o(39079);
            }
        });
        this.rtT.b(new MMSlideDelView.f() {
            public final void bN(Object obj) {
                AppMethodBeat.i(39080);
                if (obj == null) {
                    ab.e("MicroMsg.SnsMsgUI", "onItemDel object null");
                    AppMethodBeat.o(39080);
                    return;
                }
                try {
                    SnsMsgUI.a(SnsMsgUI.this, bo.ank(obj.toString()));
                    AppMethodBeat.o(39080);
                } catch (Exception e) {
                    ab.e("MicroMsg.SnsMsgUI", "onItemDel object not int");
                    ab.printErrStackTrace("MicroMsg.SnsMsgUI", e, "", new Object[0]);
                    AppMethodBeat.o(39080);
                }
            }
        });
        this.rtT.a((com.tencent.mm.ui.p.a) new com.tencent.mm.ui.p.a() {
            public final void apt() {
                AppMethodBeat.i(39081);
                ab.v("MicroMsg.SnsMsgUI", "total count:" + SnsMsgUI.this.rtT.enb + " unread:" + af.cnK().baS() + "  showcount:" + SnsMsgUI.this.rtT.kmW);
                if (SnsMsgUI.this.rtT.getCount() == 0) {
                    SnsMsgUI.this.nDp.setVisibility(8);
                    SnsMsgUI.this.nDr.setVisibility(0);
                    SnsMsgUI.this.enableOptionMenu(false);
                } else {
                    SnsMsgUI.this.nDp.setVisibility(0);
                    SnsMsgUI.this.nDr.setVisibility(8);
                    SnsMsgUI.this.enableOptionMenu(true);
                }
                if ((SnsMsgUI.this.rtT.bdn() && af.cnK().baS() == 0) || af.cnK().baS() == af.cnK().cqG()) {
                    SnsMsgUI.this.kmS.setVisibility(8);
                }
                AppMethodBeat.o(39081);
            }
        });
        this.nDp.setAdapter(this.rtT);
        this.nDp.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(39082);
                if (i == SnsMsgUI.this.rtT.getCount()) {
                    int i2;
                    if (af.cnK().baS() > 0) {
                        af.cnK().baT();
                        i2 = SnsMsgUI.this.rtT.bdn() ? 0 : 1;
                    } else {
                        i2 = SnsMsgUI.this.rtT.bdo();
                    }
                    SnsMsgUI.this.rtT.a(null, null);
                    if (!SnsMsgUI.this.kmU) {
                        if (SnsMsgUI.this.kmS.getParent() != null) {
                            ab.d("MicroMsg.SnsMsgUI", "remove footer");
                            SnsMsgUI.this.nDp.removeFooterView(SnsMsgUI.this.kmS);
                        }
                        if (SnsMsgUI.this.kmT.getParent() == null && i2 > 0) {
                            SnsMsgUI.this.nDp.addFooterView(SnsMsgUI.this.kmT);
                            ab.i("MicroMsg.SnsMsgUI", "add mLoadingFooterView");
                        }
                    }
                    SnsMsgUI.this.kmU = true;
                    SnsMsgUI.this.kmS.setVisibility(8);
                    AppMethodBeat.o(39082);
                    return;
                }
                SnsMsgUI.a(SnsMsgUI.this, (j) SnsMsgUI.this.rtT.getItem(i));
                AppMethodBeat.o(39082);
            }
        });
        com.tencent.mm.ui.tools.j jVar = new com.tencent.mm.ui.tools.j(this);
        this.nDp.setOnTouchListener(new OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                AppMethodBeat.i(39083);
                switch (motionEvent.getAction()) {
                    case 0:
                        SnsMsgUI.this.aqX();
                        SnsMsgUI.this.mkD[0] = (int) motionEvent.getRawX();
                        SnsMsgUI.this.mkD[1] = (int) motionEvent.getRawY();
                        break;
                }
                AppMethodBeat.o(39083);
                return false;
            }
        });
        this.nDp.setOnItemLongClickListener(new OnItemLongClickListener() {
            public final boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(39066);
                if (i < SnsMsgUI.this.nDp.getHeaderViewsCount()) {
                    ab.w("MicroMsg.SnsMsgUI", "on header view long click, ignore");
                    AppMethodBeat.o(39066);
                    return true;
                }
                new com.tencent.mm.ui.widget.b.a(SnsMsgUI.this).a(view, i, j, SnsMsgUI.this, SnsMsgUI.this.jKa, SnsMsgUI.this.mkD[0], SnsMsgUI.this.mkD[1]);
                AppMethodBeat.o(39066);
                return true;
            }
        });
        this.nDp.setOnScrollListener(new OnScrollListener() {
            public final void onScrollStateChanged(AbsListView absListView, int i) {
                AppMethodBeat.i(39067);
                if (SnsMsgUI.this.kmU) {
                    ab.i("MicroMsg.SnsMsgUI", "onListViewScoll %s", Integer.valueOf(i));
                    if (i == 2) {
                        WXHardCoderJNI.stopPerformance(WXHardCoderJNI.hcSNSMsgScrollEnable, SnsMsgUI.this.ehv);
                        SnsMsgUI.this.ehv = WXHardCoderJNI.startPerformance(WXHardCoderJNI.hcSNSMsgScrollEnable, WXHardCoderJNI.hcSNSMsgScrollDelay, WXHardCoderJNI.hcSNSMsgScrollCPU, WXHardCoderJNI.hcSNSMsgScrollIO, WXHardCoderJNI.hcSNSMsgScrollThr ? Process.myTid() : 0, WXHardCoderJNI.hcSNSMsgScrollTimeout, 705, WXHardCoderJNI.hcSNSMsgScrollAction, "MicroMsg.SnsMsgUI");
                        ab.i("MicroMsg.SnsMsgUI", "summer hardcoder sns startPerformance [%s]", Integer.valueOf(SnsMsgUI.this.ehv));
                    }
                    if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                        if (af.cnK().baS() > 0) {
                            af.cnK().baT();
                        } else {
                            SnsMsgUI.this.rtT.bdo();
                        }
                        SnsMsgUI.this.rtT.a(null, null);
                        AppMethodBeat.o(39067);
                        return;
                    }
                    AppMethodBeat.o(39067);
                    return;
                }
                AppMethodBeat.o(39067);
            }

            public final void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }
        });
        if (this.rtT.getCount() == 0) {
            this.nDp.setVisibility(8);
            this.nDr.setVisibility(0);
            enableOptionMenu(false);
        } else {
            this.nDp.setVisibility(0);
            this.nDr.setVisibility(8);
            enableOptionMenu(true);
        }
        if ((this.rtT.bdn() && af.cnK().baS() == 0) || af.cnK().baS() == af.cnK().cqG()) {
            this.kmS.setVisibility(8);
        }
        if (this.rtT.bdn() && this.kmU) {
            this.nDp.removeFooterView(this.kmT);
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(39068);
                Intent intent = new Intent();
                intent.putExtra("sns_cmd_list", SnsMsgUI.this.rjk);
                SnsMsgUI.this.setResult(-1, intent);
                SnsMsgUI.this.finish();
                AppMethodBeat.o(39068);
                return true;
            }
        });
        if (this.rtT.bdn() && this.kmU) {
            this.nDp.removeFooterView(this.kmT);
        }
        AppMethodBeat.o(39103);
    }

    public void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
        AppMethodBeat.i(39104);
        AdapterContextMenuInfo adapterContextMenuInfo = (AdapterContextMenuInfo) contextMenuInfo;
        j jVar = (j) this.rtT.getItem(adapterContextMenuInfo.position);
        if (jVar == null) {
            AppMethodBeat.o(39104);
            return;
        }
        this.rfb = jVar.rfb;
        this.qQp = jVar.field_snsID;
        try {
            can can = (can) new can().parseFrom(jVar.field_curActionBuf);
            if (can != null) {
                String Oj;
                ad aoO = this.rqa.aoO(can.wPm);
                if (aoO != null) {
                    Oj = aoO.Oj();
                } else if (bo.isNullOrNil(can.wZD)) {
                    Oj = can.wPm;
                } else {
                    Oj = can.wZD;
                }
                contextMenu.setHeaderTitle(bo.nullAsNil(Oj));
                if (jVar.field_isSilence == 0) {
                    contextMenu.add(adapterContextMenuInfo.position, 1, 1, getString(R.string.d_7));
                } else {
                    contextMenu.add(adapterContextMenuInfo.position, 2, 1, getString(R.string.d_6));
                }
            }
        } catch (Exception e) {
            ab.printErrStackTrace("MicroMsg.SnsMsgUI", e, "", new Object[0]);
        }
        contextMenu.add(adapterContextMenuInfo.position, 0, 0, getString(R.string.p4));
        AppMethodBeat.o(39104);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(39105);
        ab.i("MicroMsg.SnsMsgUI", "onAcvityResult requestCode:".concat(String.valueOf(i)));
        if (i2 != -1) {
            AppMethodBeat.o(39105);
        } else if (intent == null || !intent.getBooleanExtra("result_finish", false)) {
            if (intent != null) {
                this.rjk.CK(intent.getIntExtra("sns_gallery_op_id", 0));
            }
            AppMethodBeat.o(39105);
        } else {
            finish();
            AppMethodBeat.o(39105);
        }
    }

    public final void Xw(String str) {
        AppMethodBeat.i(39106);
        this.rtT.notifyDataSetChanged();
        AppMethodBeat.o(39106);
    }

    public final void bj(String str, boolean z) {
    }

    public final void cmu() {
    }

    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        AppMethodBeat.i(39107);
        if (keyEvent.getKeyCode() == 4 && keyEvent.getAction() == 0) {
            ab.d("MicroMsg.SnsMsgUI", "dispatchKeyEvent");
            Intent intent = new Intent();
            intent.putExtra("sns_cmd_list", this.rjk);
            setResult(-1, intent);
            finish();
            AppMethodBeat.o(39107);
            return true;
        }
        boolean dispatchKeyEvent = super.dispatchKeyEvent(keyEvent);
        AppMethodBeat.o(39107);
        return dispatchKeyEvent;
    }

    public void onSceneEnd(int i, int i2, String str, com.tencent.mm.ai.m mVar) {
        AppMethodBeat.i(39108);
        if (i == 0 && i2 == 0 && (mVar instanceof q)) {
            ab.d("MicroMsg.SnsMsgUI", "onSceneEnd errtype errcode");
            ctD();
        }
        if (mVar.getType() == 218) {
            if (((com.tencent.mm.plugin.sns.model.r) mVar).type != 12) {
                AppMethodBeat.o(39108);
                return;
            }
            if (i == 0 && i2 == 0) {
                this.rtT.a(null, null);
                Toast.makeText(this, getString(R.string.d__), 0).show();
            } else {
                Toast.makeText(this, getString(R.string.d_9), 0).show();
            }
            if (this.rtX != null) {
                this.rtX.dismiss();
                this.rtX = null;
            }
        }
        AppMethodBeat.o(39108);
    }

    private void ctD() {
        AppMethodBeat.i(39109);
        if (this.rtU) {
            AppMethodBeat.o(39109);
            return;
        }
        this.rtU = true;
        this.handler.postDelayed(this.rua, 500);
        AppMethodBeat.o(39109);
    }

    public final void bk(String str, boolean z) {
    }

    static /* synthetic */ void n(SnsMsgUI snsMsgUI) {
        AppMethodBeat.i(39112);
        h.d(snsMsgUI, snsMsgUI.getString(R.string.d_8), "", snsMsgUI.getString(R.string.d_7), snsMsgUI.getString(R.string.or), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                AppMethodBeat.i(39071);
                SnsMsgUI.a(SnsMsgUI.this, true);
                AppMethodBeat.o(39071);
            }
        }, null);
        AppMethodBeat.o(39112);
    }
}
