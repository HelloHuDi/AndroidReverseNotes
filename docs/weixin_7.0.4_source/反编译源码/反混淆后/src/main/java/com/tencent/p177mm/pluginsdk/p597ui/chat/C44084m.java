package com.tencent.p177mm.pluginsdk.p597ui.chat;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.ImageView.ScaleType;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C46633o;
import com.tencent.p177mm.p612ui.base.HorizontalListView;
import com.tencent.p177mm.p612ui.base.HorizontalListView.C15504a;
import com.tencent.p177mm.plugin.emoji.PluginEmoji;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.emoji.PreViewEmojiView;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/* renamed from: com.tencent.mm.pluginsdk.ui.chat.m */
public final class C44084m {
    /* renamed from: WL */
    private View f17238WL;
    private OnItemClickListener arw = new C149403();
    private int jlr = 3;
    ArrayList<EmojiInfo> lbH = new ArrayList();
    Context mContext;
    C7306ak mHandler = new C404781();
    C23298a vnn;
    int voC;
    int voD;
    C46633o voE;
    View voF;
    C23297j voG;
    String voH;
    public String voI = "";
    public boolean voJ = true;
    private HorizontalListView voK;
    C4755b voL;
    private boolean voM = true;
    private Comparator voN = new C440852();
    private C15504a voO = new C149414();

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.m$b */
    class C4755b extends BaseAdapter {
        ArrayList<EmojiInfo> mData;

        C4755b() {
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.m2504i(62463);
            EmojiInfo uf = mo9903uf(i);
            AppMethodBeat.m2505o(62463);
            return uf;
        }

        public final int getCount() {
            AppMethodBeat.m2504i(62460);
            if (this.mData == null) {
                AppMethodBeat.m2505o(62460);
                return 0;
            }
            int size = this.mData.size();
            AppMethodBeat.m2505o(62460);
            return size;
        }

        /* renamed from: uf */
        public final EmojiInfo mo9903uf(int i) {
            AppMethodBeat.m2504i(62461);
            if (this.mData == null || this.mData.size() <= i) {
                AppMethodBeat.m2505o(62461);
                return null;
            }
            EmojiInfo emojiInfo = (EmojiInfo) this.mData.get(i);
            AppMethodBeat.m2505o(62461);
            return emojiInfo;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            C35871c c35871c;
            AppMethodBeat.m2504i(62462);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(C44084m.this.mContext).inflate(2130969025, null);
                C35871c c35871c2 = new C35871c(view);
                view.setTag(c35871c2);
                c35871c = c35871c2;
            } else {
                c35871c = (C35871c) view.getTag();
            }
            EmojiInfo uf = mo9903uf(i);
            c35871c.voQ.setSize(C44084m.this.voC);
            c35871c.voQ.setScaleType(ScaleType.CENTER_INSIDE);
            String str = "";
            if (uf != null) {
                str = ((PluginEmoji) C1720g.m3530M(PluginEmoji.class)).getEmojiMgr().mo35600Jh(uf.mo20410Aq());
            }
            if (C5046bo.isNullOrNil(str)) {
                c35871c.voQ.setContentDescription(C44084m.this.mContext.getString(C25738R.string.bc5));
            } else {
                c35871c.voQ.setContentDescription(str);
            }
            if (uf == null) {
                C4990ab.m7420w("MicroMsg.emoji.SuggestEmoticonBubble", "emoji info is null.");
            } else if (uf.duS()) {
                c35871c.voQ.mo46175b(EmojiInfo.m48210bJ(C44084m.this.mContext, uf.getName()), uf.getName());
            } else {
                c35871c.voQ.mo56663a(uf, "");
            }
            AppMethodBeat.m2505o(62462);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.m$3 */
    class C149403 implements OnItemClickListener {
        C149403() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(62456);
            EmojiInfo uf = C44084m.this.voL == null ? null : C44084m.this.voL.mo9903uf(i);
            if (!(uf == null || C44084m.this.voG == null || C44084m.this.vnn == null)) {
                C44084m.this.voG.mo39016A(uf);
                C44084m.this.vnn.clear();
                C7060h.pYm.mo8381e(10994, Integer.valueOf(1), C44084m.this.voH, "", Integer.valueOf(i), uf.mo20410Aq(), Integer.valueOf(C44084m.this.voL.getCount()));
            }
            C44084m.this.voE.dismiss();
            AppMethodBeat.m2505o(62456);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.m$4 */
    class C149414 implements C15504a {
        C149414() {
        }

        /* renamed from: o */
        public final boolean mo27288o(MotionEvent motionEvent) {
            AppMethodBeat.m2504i(62457);
            switch (motionEvent.getAction()) {
                case 0:
                    C44084m.this.mHandler.sendEmptyMessage(20002);
                    break;
                case 1:
                case 3:
                    C44084m.this.mHandler.sendEmptyMessageDelayed(CdnLogic.kMediaTypeBackupFile, 3000);
                    break;
            }
            AppMethodBeat.m2505o(62457);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.m$6 */
    public class C149426 implements Runnable {
        final /* synthetic */ String fOH;

        public C149426(String str) {
            this.fOH = str;
        }

        public final void run() {
            AppMethodBeat.m2504i(62459);
            if (C44084m.this.mo69787cM(this.fOH)) {
                C44084m.this.mHandler.sendEmptyMessage(20003);
                AppMethodBeat.m2505o(62459);
                return;
            }
            C44084m.this.mHandler.removeMessages(20003);
            C44084m.this.mHandler.sendEmptyMessage(CdnLogic.kMediaTypeBackupFile);
            AppMethodBeat.m2505o(62459);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.m$a */
    public interface C23298a {
        void clear();
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.m$5 */
    class C301265 implements OnItemSelectedListener {
        C301265() {
        }

        public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(62458);
            C4990ab.m7410d("MicroMsg.emoji.SuggestEmoticonBubble", "onItemSelected ...");
            AppMethodBeat.m2505o(62458);
        }

        public final void onNothingSelected(AdapterView<?> adapterView) {
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.m$c */
    class C35871c {
        PreViewEmojiView voQ;

        public C35871c(View view) {
            AppMethodBeat.m2504i(62464);
            this.voQ = (PreViewEmojiView) view.findViewById(2131822406);
            this.voQ.setSize(C44084m.this.voC);
            AppMethodBeat.m2505o(62464);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.m$1 */
    class C404781 extends C7306ak {
        C404781() {
        }

        public final void handleMessage(Message message) {
            int i = 0;
            AppMethodBeat.m2504i(62455);
            switch (message.what) {
                case CdnLogic.kMediaTypeBackupFile /*20001*/:
                    C44084m.this.hide();
                    AppMethodBeat.m2505o(62455);
                    return;
                case 20002:
                    removeMessages(CdnLogic.kMediaTypeBackupFile);
                    break;
                case 20003:
                    C44084m c44084m = C44084m.this;
                    c44084m.mHandler.removeMessages(CdnLogic.kMediaTypeBackupFile);
                    if (c44084m.voJ) {
                        C4755b c4755b = c44084m.voL;
                        c4755b.mData = c44084m.lbH;
                        c4755b.notifyDataSetInvalidated();
                        if (c44084m.lbH != null && c44084m.lbH.size() > 2) {
                            c44084m.voE.setWidth(((int) (((double) c44084m.voC) * 2.5d)) + (c44084m.voD * 2));
                        } else if (c44084m.lbH == null || c44084m.lbH.size() != 2) {
                            c44084m.voE.setWidth(c44084m.voC + (c44084m.voD * 2));
                        } else {
                            c44084m.voE.setWidth((c44084m.voC * 2) + (c44084m.voD * 2));
                        }
                        c44084m.dkL();
                        if (c44084m.lbH == null || c44084m.lbH.size() < 3) {
                            c44084m.mHandler.sendEmptyMessageDelayed(CdnLogic.kMediaTypeBackupFile, 3000);
                        } else {
                            c44084m.mHandler.sendEmptyMessageDelayed(CdnLogic.kMediaTypeBackupFile, 5000);
                        }
                        C7060h c7060h = C7060h.pYm;
                        Object[] objArr = new Object[6];
                        objArr[0] = Integer.valueOf(0);
                        objArr[1] = c44084m.voH;
                        objArr[2] = "";
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = "";
                        if (c44084m.lbH != null) {
                            i = c44084m.lbH.size();
                        }
                        objArr[5] = Integer.valueOf(i);
                        c7060h.mo8381e(10994, objArr);
                    }
                    AppMethodBeat.m2505o(62455);
                    return;
            }
            AppMethodBeat.m2505o(62455);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.m$2 */
    class C440852 implements Comparator<EmojiInfo> {
        C440852() {
        }

        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            EmojiInfo emojiInfo = (EmojiInfo) obj;
            EmojiInfo emojiInfo2 = (EmojiInfo) obj2;
            if (emojiInfo == null && emojiInfo2 == null) {
                return 0;
            }
            if (emojiInfo != null) {
                if (emojiInfo2 == null) {
                    return 1;
                }
                if (emojiInfo.field_lastUseTime == emojiInfo2.field_lastUseTime) {
                    return 0;
                }
                if (emojiInfo.field_lastUseTime > emojiInfo2.field_lastUseTime) {
                    return 1;
                }
            }
            return -1;
        }
    }

    public C44084m(Context context) {
        AppMethodBeat.m2504i(62465);
        this.mContext = context;
        this.f17238WL = View.inflate(this.mContext, 2130969024, null);
        this.voK = (HorizontalListView) this.f17238WL.findViewById(2131822440);
        this.voL = new C4755b();
        this.voK.setAdapter(this.voL);
        this.voK.setOnItemClickListener(this.arw);
        this.voK.setOnItemSelectedListener(new C301265());
        this.voK.setDispatchTouchListener(this.voO);
        this.voC = C1338a.m2856al(this.mContext, C25738R.dimen.a1d);
        this.voD = C1338a.m2856al(this.mContext, C25738R.dimen.f9966lo);
        this.voE = new C46633o(this.f17238WL, this.voC + (this.voD * 2), this.voC + (this.voD * 2), true);
        this.voE.setBackgroundDrawable(new ColorDrawable(0));
        this.voE.setOutsideTouchable(true);
        this.voE.setFocusable(false);
        AppMethodBeat.m2505o(62465);
    }

    public final void dkL() {
        AppMethodBeat.m2504i(62466);
        if (this.voF != null) {
            int[] iArr = new int[2];
            this.voF.getLocationInWindow(iArr);
            this.voE.showAtLocation(this.voF, 0, iArr[0] - ((this.voE.getWidth() - this.voF.getWidth()) / 2), iArr[1] - this.voE.getHeight());
        }
        AppMethodBeat.m2505o(62466);
    }

    public final void hide() {
        AppMethodBeat.m2504i(62467);
        if (this.voE == null) {
            AppMethodBeat.m2505o(62467);
            return;
        }
        if (this.voE.isShowing()) {
            this.voE.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        AppMethodBeat.m2505o(62467);
    }

    /* renamed from: cM */
    public final boolean mo69787cM(String str) {
        AppMethodBeat.m2504i(62468);
        try {
            if (!C5046bo.isNullOrNil(str)) {
                ArrayList Jj = ((PluginEmoji) C1720g.m3530M(PluginEmoji.class)).getEmojiMgr().mo35602Jj(str);
                if (!(Jj == null || Jj.isEmpty())) {
                    this.voH = str.replaceAll(",", "");
                    if (Jj == null || Jj.isEmpty()) {
                        AppMethodBeat.m2505o(62468);
                        return false;
                    }
                    EmojiInfo Jd;
                    ArrayList arrayList = new ArrayList();
                    this.lbH.clear();
                    int size = Jj.size();
                    int i = 0;
                    while (i < size && i < 100) {
                        Jd = ((PluginEmoji) C1720g.m3530M(PluginEmoji.class)).getEmojiMgr().mo35596Jd((String) Jj.get(i));
                        if (Jd != null) {
                            arrayList.add(Jd);
                        }
                        i++;
                    }
                    if (arrayList.isEmpty()) {
                        C4990ab.m7416i("MicroMsg.emoji.SuggestEmoticonBubble", "sorEmojiList return. empty list.");
                        AppMethodBeat.m2505o(62468);
                        return false;
                    }
                    if (this.voM) {
                        Jd = (EmojiInfo) Collections.max(arrayList, this.voN);
                        this.lbH.add(Jd);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            EmojiInfo emojiInfo = (EmojiInfo) it.next();
                            if (!(emojiInfo.mo48515cJ(Jd) || this.lbH.contains(emojiInfo))) {
                                this.lbH.add(emojiInfo);
                            }
                        }
                    } else {
                        Iterator it2 = arrayList.iterator();
                        while (it2.hasNext()) {
                            Jd = (EmojiInfo) it2.next();
                            if (!this.lbH.contains(Jd)) {
                                this.lbH.add(Jd);
                            }
                        }
                    }
                    if (this.lbH == null || this.lbH.isEmpty()) {
                        AppMethodBeat.m2505o(62468);
                        return false;
                    }
                    AppMethodBeat.m2505o(62468);
                    return true;
                }
            }
        } catch (Exception e) {
            C4990ab.m7412e("MicroMsg.emoji.SuggestEmoticonBubble", C5046bo.m7574l(e));
        }
        this.voH = "";
        AppMethodBeat.m2505o(62468);
        return false;
    }
}
