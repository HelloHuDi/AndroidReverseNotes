package com.tencent.p177mm.plugin.emoji.p381a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.p190at.C32291o;
import com.tencent.p177mm.p190at.p191a.p193c.C1282i;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C46637x;
import com.tencent.p177mm.plugin.emoji.model.C45859a;
import com.tencent.p177mm.plugin.emoji.model.EmojiLogic;
import com.tencent.p177mm.plugin.emoji.p384ui.EmojiStoreVpHeader;
import com.tencent.p177mm.plugin.emoji.p947e.C11553m;
import com.tencent.p177mm.plugin.emoji.p947e.C20364g;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.emoji.StoreBannerEmojiView;
import com.tencent.p177mm.protocal.protobuf.EmotionSummary;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5004al;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.emotion.EmojiInfo;
import java.util.ArrayList;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.emoji.a.i */
public final class C38872i extends C46637x implements OnClickListener {
    public static int kSE = 60;
    public LinkedList<C45859a> kSD;
    private int kSF = 0;
    private boolean kSG = false;
    private ArrayList<String> kSH = new ArrayList();
    private C38874a kSI = new C38874a();
    private Context mContext;

    /* renamed from: com.tencent.mm.plugin.emoji.a.i$b */
    class C38873b {
        StoreBannerEmojiView kSL;
        ImageView kSM;

        public C38873b(View view) {
            AppMethodBeat.m2504i(52765);
            this.kSL = (StoreBannerEmojiView) view.findViewById(2131823548);
            this.kSM = (ImageView) view.findViewById(2131823549);
            this.kSL.setDefaultImageResource(0);
            AppMethodBeat.m2505o(52765);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.a.i$a */
    static class C38874a implements C1282i {
        C38872i kSJ;

        /* renamed from: com.tencent.mm.plugin.emoji.a.i$a$1 */
        class C277291 implements Runnable {
            C277291() {
            }

            public final void run() {
                AppMethodBeat.m2504i(52763);
                if (C38874a.this.kSJ != null) {
                    C38874a.this.kSJ.notifyDataSetChanged();
                }
                AppMethodBeat.m2505o(52763);
            }
        }

        private C38874a() {
        }

        /* synthetic */ C38874a(byte b) {
            this();
        }

        /* renamed from: a */
        public final void mo4581a(String str, View view, Bitmap bitmap, Object... objArr) {
            AppMethodBeat.m2504i(52764);
            C4990ab.m7417i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "onImageLoadComplete url:%s", str);
            C5004al.m7441d(new C277291());
            AppMethodBeat.m2505o(52764);
        }
    }

    public C38872i(Context context, LinkedList<C45859a> linkedList) {
        AppMethodBeat.m2504i(52766);
        if (linkedList == null) {
            IllegalAccessError illegalAccessError = new IllegalAccessError("must has emoji banner list");
            AppMethodBeat.m2505o(52766);
            throw illegalAccessError;
        }
        this.mContext = context;
        this.kSD = new LinkedList();
        this.kSD.addAll(linkedList);
        this.kSI.kSJ = this;
        AppMethodBeat.m2505o(52766);
    }

    public final int getCount() {
        AppMethodBeat.m2504i(52767);
        if (this.kSD == null) {
            AppMethodBeat.m2505o(52767);
            return 0;
        } else if (this.kSD.size() == 1) {
            AppMethodBeat.m2505o(52767);
            return 1;
        } else {
            int size = this.kSD.size() * kSE;
            AppMethodBeat.m2505o(52767);
            return size;
        }
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.m2504i(52768);
        if (this.kSG) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "has destroy need to notify");
            AppMethodBeat.m2505o(52768);
            return;
        }
        this.kSF = getCount();
        super.notifyDataSetChanged();
        AppMethodBeat.m2505o(52768);
    }

    public final int getItemPosition(Object obj) {
        AppMethodBeat.m2504i(52769);
        if (this.kSF > 0) {
            this.kSF--;
            AppMethodBeat.m2505o(52769);
            return -2;
        }
        int itemPosition = super.getItemPosition(obj);
        AppMethodBeat.m2505o(52769);
        return itemPosition;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.m2504i(52770);
        if (this.kSD == null) {
            AppMethodBeat.m2505o(52770);
            return null;
        }
        C38873b c38873b;
        int size = i % this.kSD.size();
        C38873b c38873b2;
        if (view == null) {
            C4990ab.m7416i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "getView inflate");
            view = View.inflate(this.mContext, 2130969387, null);
            c38873b2 = new C38873b(view);
            view.setTag(c38873b2);
            c38873b = c38873b2;
        } else {
            c38873b2 = (C38873b) view.getTag();
            int i2 = EmojiStoreVpHeader.m44112db(this.mContext)[0];
            c38873b2.kSL.setLayoutParams(new LayoutParams(i2, ((i2 * 3) / 8) + 1));
            c38873b = c38873b2;
        }
        view.setTag(2131820595, Integer.valueOf(size));
        view.setOnClickListener(this);
        C45859a c45859a = (C45859a) this.kSD.get(size);
        if (c45859a == null) {
            C4990ab.m7412e("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "BaseEmotionBanner is null.");
            AppMethodBeat.m2505o(52770);
            return null;
        }
        String str;
        String str2;
        if (c45859a.kVa) {
            str = c45859a.kUY.BannerImg.StripUrl;
            if (C5046bo.isNullOrNil(c45859a.kUY.LocateUrl)) {
                str2 = "H5";
            } else {
                str2 = "Toptic";
            }
        } else {
            str = c45859a.kUZ.BannerImg.StripUrl;
            str2 = c45859a.kUZ.BannerSummary.ProductID;
        }
        if (!(c45859a == null || C5046bo.isNullOrNil(str))) {
            C1338a.getDensity(this.mContext);
            EmojiInfo r = EmojiLogic.m44081r(str2, 8, str);
            if (r != null) {
                c38873b.kSL.setImageFilePath(r.dve());
            } else if (this.kSH.contains(str)) {
                C4990ab.m7416i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "url has add to list. no need to try load image.");
                c38873b.kSL.setImageFilePath("-");
            } else {
                C32291o.ahp().mo43768a(str, null, C20364g.m31463j(str2, str, str2, "BANNER"), this.kSI);
                this.kSH.add(str);
            }
        }
        C4990ab.m7411d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "position:%d allPostion:%d banner url:%s ", Integer.valueOf(size), Integer.valueOf(i), str);
        AppMethodBeat.m2505o(52770);
        return view;
    }

    public final void clear() {
        AppMethodBeat.m2504i(52771);
        if (this.kSD != null) {
            this.kSD.clear();
        }
        if (this.kSH != null) {
            this.kSH.clear();
        }
        this.kSG = true;
        this.kSI.kSJ = null;
        AppMethodBeat.m2505o(52771);
    }

    public final void onClick(View view) {
        AppMethodBeat.m2504i(52772);
        C45859a c45859a = (C45859a) this.kSD.get(((Integer) view.getTag(2131820595)).intValue());
        if (c45859a != null) {
            if (c45859a.kVa) {
                C11553m.m19374a(this.mContext, c45859a.kUY, true);
                AppMethodBeat.m2505o(52772);
                return;
            }
            EmotionSummary emotionSummary = c45859a.kUZ.BannerSummary;
            if (emotionSummary != null) {
                String str = "MicroMsg.emoji.EmojiStoreVpHeaderAdapter";
                String str2 = "productId %s";
                Object[] objArr = new Object[1];
                objArr[0] = emotionSummary == null ? "" : emotionSummary.ProductID;
                C4990ab.m7411d(str, str2, objArr);
                C7060h.pYm.mo8381e(11929, Integer.valueOf(0));
                C11553m.m19375a(this.mContext, emotionSummary, 15, -1, -1, "", 8);
            }
        }
        AppMethodBeat.m2505o(52772);
    }
}
