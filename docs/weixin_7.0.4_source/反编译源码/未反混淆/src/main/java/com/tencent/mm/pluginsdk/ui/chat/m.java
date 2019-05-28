package com.tencent.mm.pluginsdk.ui.chat;

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
import com.tencent.mm.R;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emoji.PluginEmoji;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.PreViewEmojiView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.HorizontalListView;
import com.tencent.mm.ui.base.o;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public final class m {
    private View WL;
    private OnItemClickListener arw = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.i(62456);
            EmojiInfo uf = m.this.voL == null ? null : m.this.voL.uf(i);
            if (!(uf == null || m.this.voG == null || m.this.vnn == null)) {
                m.this.voG.A(uf);
                m.this.vnn.clear();
                h.pYm.e(10994, Integer.valueOf(1), m.this.voH, "", Integer.valueOf(i), uf.Aq(), Integer.valueOf(m.this.voL.getCount()));
            }
            m.this.voE.dismiss();
            AppMethodBeat.o(62456);
        }
    };
    private int jlr = 3;
    ArrayList<EmojiInfo> lbH = new ArrayList();
    Context mContext;
    ak mHandler = new ak() {
        public final void handleMessage(Message message) {
            int i = 0;
            AppMethodBeat.i(62455);
            switch (message.what) {
                case CdnLogic.kMediaTypeBackupFile /*20001*/:
                    m.this.hide();
                    AppMethodBeat.o(62455);
                    return;
                case 20002:
                    removeMessages(CdnLogic.kMediaTypeBackupFile);
                    break;
                case 20003:
                    m mVar = m.this;
                    mVar.mHandler.removeMessages(CdnLogic.kMediaTypeBackupFile);
                    if (mVar.voJ) {
                        b bVar = mVar.voL;
                        bVar.mData = mVar.lbH;
                        bVar.notifyDataSetInvalidated();
                        if (mVar.lbH != null && mVar.lbH.size() > 2) {
                            mVar.voE.setWidth(((int) (((double) mVar.voC) * 2.5d)) + (mVar.voD * 2));
                        } else if (mVar.lbH == null || mVar.lbH.size() != 2) {
                            mVar.voE.setWidth(mVar.voC + (mVar.voD * 2));
                        } else {
                            mVar.voE.setWidth((mVar.voC * 2) + (mVar.voD * 2));
                        }
                        mVar.dkL();
                        if (mVar.lbH == null || mVar.lbH.size() < 3) {
                            mVar.mHandler.sendEmptyMessageDelayed(CdnLogic.kMediaTypeBackupFile, 3000);
                        } else {
                            mVar.mHandler.sendEmptyMessageDelayed(CdnLogic.kMediaTypeBackupFile, 5000);
                        }
                        h hVar = h.pYm;
                        Object[] objArr = new Object[6];
                        objArr[0] = Integer.valueOf(0);
                        objArr[1] = mVar.voH;
                        objArr[2] = "";
                        objArr[3] = Integer.valueOf(0);
                        objArr[4] = "";
                        if (mVar.lbH != null) {
                            i = mVar.lbH.size();
                        }
                        objArr[5] = Integer.valueOf(i);
                        hVar.e(10994, objArr);
                    }
                    AppMethodBeat.o(62455);
                    return;
            }
            AppMethodBeat.o(62455);
        }
    };
    a vnn;
    int voC;
    int voD;
    o voE;
    View voF;
    j voG;
    String voH;
    public String voI = "";
    public boolean voJ = true;
    private HorizontalListView voK;
    b voL;
    private boolean voM = true;
    private Comparator voN = new Comparator<EmojiInfo>() {
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
    };
    private com.tencent.mm.ui.base.HorizontalListView.a voO = new com.tencent.mm.ui.base.HorizontalListView.a() {
        public final boolean o(MotionEvent motionEvent) {
            AppMethodBeat.i(62457);
            switch (motionEvent.getAction()) {
                case 0:
                    m.this.mHandler.sendEmptyMessage(20002);
                    break;
                case 1:
                case 3:
                    m.this.mHandler.sendEmptyMessageDelayed(CdnLogic.kMediaTypeBackupFile, 3000);
                    break;
            }
            AppMethodBeat.o(62457);
            return false;
        }
    };

    class b extends BaseAdapter {
        ArrayList<EmojiInfo> mData;

        b() {
        }

        public final /* synthetic */ Object getItem(int i) {
            AppMethodBeat.i(62463);
            EmojiInfo uf = uf(i);
            AppMethodBeat.o(62463);
            return uf;
        }

        public final int getCount() {
            AppMethodBeat.i(62460);
            if (this.mData == null) {
                AppMethodBeat.o(62460);
                return 0;
            }
            int size = this.mData.size();
            AppMethodBeat.o(62460);
            return size;
        }

        public final EmojiInfo uf(int i) {
            AppMethodBeat.i(62461);
            if (this.mData == null || this.mData.size() <= i) {
                AppMethodBeat.o(62461);
                return null;
            }
            EmojiInfo emojiInfo = (EmojiInfo) this.mData.get(i);
            AppMethodBeat.o(62461);
            return emojiInfo;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            c cVar;
            AppMethodBeat.i(62462);
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(m.this.mContext).inflate(R.layout.lf, null);
                c cVar2 = new c(view);
                view.setTag(cVar2);
                cVar = cVar2;
            } else {
                cVar = (c) view.getTag();
            }
            EmojiInfo uf = uf(i);
            cVar.voQ.setSize(m.this.voC);
            cVar.voQ.setScaleType(ScaleType.CENTER_INSIDE);
            String str = "";
            if (uf != null) {
                str = ((PluginEmoji) g.M(PluginEmoji.class)).getEmojiMgr().Jh(uf.Aq());
            }
            if (bo.isNullOrNil(str)) {
                cVar.voQ.setContentDescription(m.this.mContext.getString(R.string.bc5));
            } else {
                cVar.voQ.setContentDescription(str);
            }
            if (uf == null) {
                ab.w("MicroMsg.emoji.SuggestEmoticonBubble", "emoji info is null.");
            } else if (uf.duS()) {
                cVar.voQ.b(EmojiInfo.bJ(m.this.mContext, uf.getName()), uf.getName());
            } else {
                cVar.voQ.a(uf, "");
            }
            AppMethodBeat.o(62462);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.chat.m$6 */
    public class AnonymousClass6 implements Runnable {
        final /* synthetic */ String fOH;

        public AnonymousClass6(String str) {
            this.fOH = str;
        }

        public final void run() {
            AppMethodBeat.i(62459);
            if (m.this.cM(this.fOH)) {
                m.this.mHandler.sendEmptyMessage(20003);
                AppMethodBeat.o(62459);
                return;
            }
            m.this.mHandler.removeMessages(20003);
            m.this.mHandler.sendEmptyMessage(CdnLogic.kMediaTypeBackupFile);
            AppMethodBeat.o(62459);
        }
    }

    public interface a {
        void clear();
    }

    class c {
        PreViewEmojiView voQ;

        public c(View view) {
            AppMethodBeat.i(62464);
            this.voQ = (PreViewEmojiView) view.findViewById(R.id.ama);
            this.voQ.setSize(m.this.voC);
            AppMethodBeat.o(62464);
        }
    }

    public m(Context context) {
        AppMethodBeat.i(62465);
        this.mContext = context;
        this.WL = View.inflate(this.mContext, R.layout.le, null);
        this.voK = (HorizontalListView) this.WL.findViewById(R.id.an8);
        this.voL = new b();
        this.voK.setAdapter(this.voL);
        this.voK.setOnItemClickListener(this.arw);
        this.voK.setOnItemSelectedListener(new OnItemSelectedListener() {
            public final void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(62458);
                ab.d("MicroMsg.emoji.SuggestEmoticonBubble", "onItemSelected ...");
                AppMethodBeat.o(62458);
            }

            public final void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        this.voK.setDispatchTouchListener(this.voO);
        this.voC = com.tencent.mm.bz.a.al(this.mContext, R.dimen.a1d);
        this.voD = com.tencent.mm.bz.a.al(this.mContext, R.dimen.lo);
        this.voE = new o(this.WL, this.voC + (this.voD * 2), this.voC + (this.voD * 2), true);
        this.voE.setBackgroundDrawable(new ColorDrawable(0));
        this.voE.setOutsideTouchable(true);
        this.voE.setFocusable(false);
        AppMethodBeat.o(62465);
    }

    public final void dkL() {
        AppMethodBeat.i(62466);
        if (this.voF != null) {
            int[] iArr = new int[2];
            this.voF.getLocationInWindow(iArr);
            this.voE.showAtLocation(this.voF, 0, iArr[0] - ((this.voE.getWidth() - this.voF.getWidth()) / 2), iArr[1] - this.voE.getHeight());
        }
        AppMethodBeat.o(62466);
    }

    public final void hide() {
        AppMethodBeat.i(62467);
        if (this.voE == null) {
            AppMethodBeat.o(62467);
            return;
        }
        if (this.voE.isShowing()) {
            this.voE.dismiss();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        AppMethodBeat.o(62467);
    }

    public final boolean cM(String str) {
        AppMethodBeat.i(62468);
        try {
            if (!bo.isNullOrNil(str)) {
                ArrayList Jj = ((PluginEmoji) g.M(PluginEmoji.class)).getEmojiMgr().Jj(str);
                if (!(Jj == null || Jj.isEmpty())) {
                    this.voH = str.replaceAll(",", "");
                    if (Jj == null || Jj.isEmpty()) {
                        AppMethodBeat.o(62468);
                        return false;
                    }
                    EmojiInfo Jd;
                    ArrayList arrayList = new ArrayList();
                    this.lbH.clear();
                    int size = Jj.size();
                    int i = 0;
                    while (i < size && i < 100) {
                        Jd = ((PluginEmoji) g.M(PluginEmoji.class)).getEmojiMgr().Jd((String) Jj.get(i));
                        if (Jd != null) {
                            arrayList.add(Jd);
                        }
                        i++;
                    }
                    if (arrayList.isEmpty()) {
                        ab.i("MicroMsg.emoji.SuggestEmoticonBubble", "sorEmojiList return. empty list.");
                        AppMethodBeat.o(62468);
                        return false;
                    }
                    if (this.voM) {
                        Jd = (EmojiInfo) Collections.max(arrayList, this.voN);
                        this.lbH.add(Jd);
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            EmojiInfo emojiInfo = (EmojiInfo) it.next();
                            if (!(emojiInfo.cJ(Jd) || this.lbH.contains(emojiInfo))) {
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
                        AppMethodBeat.o(62468);
                        return false;
                    }
                    AppMethodBeat.o(62468);
                    return true;
                }
            }
        } catch (Exception e) {
            ab.e("MicroMsg.emoji.SuggestEmoticonBubble", bo.l(e));
        }
        this.voH = "";
        AppMethodBeat.o(62468);
        return false;
    }
}
