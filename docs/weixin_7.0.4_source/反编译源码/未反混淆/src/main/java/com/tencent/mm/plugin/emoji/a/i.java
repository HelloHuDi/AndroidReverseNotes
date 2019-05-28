package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.at.o;
import com.tencent.mm.plugin.emoji.e.g;
import com.tencent.mm.plugin.emoji.e.m;
import com.tencent.mm.plugin.emoji.model.EmojiLogic;
import com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.pluginsdk.ui.emoji.StoreBannerEmojiView;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.ui.base.x;
import java.util.ArrayList;
import java.util.LinkedList;

public final class i extends x implements OnClickListener {
    public static int kSE = 60;
    public LinkedList<com.tencent.mm.plugin.emoji.model.a> kSD;
    private int kSF = 0;
    private boolean kSG = false;
    private ArrayList<String> kSH = new ArrayList();
    private a kSI = new a();
    private Context mContext;

    class b {
        StoreBannerEmojiView kSL;
        ImageView kSM;

        public b(View view) {
            AppMethodBeat.i(52765);
            this.kSL = (StoreBannerEmojiView) view.findViewById(R.id.bg7);
            this.kSM = (ImageView) view.findViewById(R.id.bg8);
            this.kSL.setDefaultImageResource(0);
            AppMethodBeat.o(52765);
        }
    }

    static class a implements com.tencent.mm.at.a.c.i {
        i kSJ;

        private a() {
        }

        /* synthetic */ a(byte b) {
            this();
        }

        public final void a(String str, View view, Bitmap bitmap, Object... objArr) {
            AppMethodBeat.i(52764);
            ab.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "onImageLoadComplete url:%s", str);
            al.d(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(52763);
                    if (a.this.kSJ != null) {
                        a.this.kSJ.notifyDataSetChanged();
                    }
                    AppMethodBeat.o(52763);
                }
            });
            AppMethodBeat.o(52764);
        }
    }

    public i(Context context, LinkedList<com.tencent.mm.plugin.emoji.model.a> linkedList) {
        AppMethodBeat.i(52766);
        if (linkedList == null) {
            IllegalAccessError illegalAccessError = new IllegalAccessError("must has emoji banner list");
            AppMethodBeat.o(52766);
            throw illegalAccessError;
        }
        this.mContext = context;
        this.kSD = new LinkedList();
        this.kSD.addAll(linkedList);
        this.kSI.kSJ = this;
        AppMethodBeat.o(52766);
    }

    public final int getCount() {
        AppMethodBeat.i(52767);
        if (this.kSD == null) {
            AppMethodBeat.o(52767);
            return 0;
        } else if (this.kSD.size() == 1) {
            AppMethodBeat.o(52767);
            return 1;
        } else {
            int size = this.kSD.size() * kSE;
            AppMethodBeat.o(52767);
            return size;
        }
    }

    public final void notifyDataSetChanged() {
        AppMethodBeat.i(52768);
        if (this.kSG) {
            ab.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "has destroy need to notify");
            AppMethodBeat.o(52768);
            return;
        }
        this.kSF = getCount();
        super.notifyDataSetChanged();
        AppMethodBeat.o(52768);
    }

    public final int getItemPosition(Object obj) {
        AppMethodBeat.i(52769);
        if (this.kSF > 0) {
            this.kSF--;
            AppMethodBeat.o(52769);
            return -2;
        }
        int itemPosition = super.getItemPosition(obj);
        AppMethodBeat.o(52769);
        return itemPosition;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        AppMethodBeat.i(52770);
        if (this.kSD == null) {
            AppMethodBeat.o(52770);
            return null;
        }
        b bVar;
        int size = i % this.kSD.size();
        b bVar2;
        if (view == null) {
            ab.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "getView inflate");
            view = View.inflate(this.mContext, R.layout.v6, null);
            bVar2 = new b(view);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar2 = (b) view.getTag();
            int i2 = EmojiStoreVpHeader.db(this.mContext)[0];
            bVar2.kSL.setLayoutParams(new LayoutParams(i2, ((i2 * 3) / 8) + 1));
            bVar = bVar2;
        }
        view.setTag(R.id.ao, Integer.valueOf(size));
        view.setOnClickListener(this);
        com.tencent.mm.plugin.emoji.model.a aVar = (com.tencent.mm.plugin.emoji.model.a) this.kSD.get(size);
        if (aVar == null) {
            ab.e("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "BaseEmotionBanner is null.");
            AppMethodBeat.o(52770);
            return null;
        }
        String str;
        String str2;
        if (aVar.kVa) {
            str = aVar.kUY.BannerImg.StripUrl;
            if (bo.isNullOrNil(aVar.kUY.LocateUrl)) {
                str2 = "H5";
            } else {
                str2 = "Toptic";
            }
        } else {
            str = aVar.kUZ.BannerImg.StripUrl;
            str2 = aVar.kUZ.BannerSummary.ProductID;
        }
        if (!(aVar == null || bo.isNullOrNil(str))) {
            com.tencent.mm.bz.a.getDensity(this.mContext);
            EmojiInfo r = EmojiLogic.r(str2, 8, str);
            if (r != null) {
                bVar.kSL.setImageFilePath(r.dve());
            } else if (this.kSH.contains(str)) {
                ab.i("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "url has add to list. no need to try load image.");
                bVar.kSL.setImageFilePath("-");
            } else {
                o.ahp().a(str, null, g.j(str2, str, str2, "BANNER"), this.kSI);
                this.kSH.add(str);
            }
        }
        ab.d("MicroMsg.emoji.EmojiStoreVpHeaderAdapter", "position:%d allPostion:%d banner url:%s ", Integer.valueOf(size), Integer.valueOf(i), str);
        AppMethodBeat.o(52770);
        return view;
    }

    public final void clear() {
        AppMethodBeat.i(52771);
        if (this.kSD != null) {
            this.kSD.clear();
        }
        if (this.kSH != null) {
            this.kSH.clear();
        }
        this.kSG = true;
        this.kSI.kSJ = null;
        AppMethodBeat.o(52771);
    }

    public final void onClick(View view) {
        AppMethodBeat.i(52772);
        com.tencent.mm.plugin.emoji.model.a aVar = (com.tencent.mm.plugin.emoji.model.a) this.kSD.get(((Integer) view.getTag(R.id.ao)).intValue());
        if (aVar != null) {
            if (aVar.kVa) {
                m.a(this.mContext, aVar.kUY, true);
                AppMethodBeat.o(52772);
                return;
            }
            EmotionSummary emotionSummary = aVar.kUZ.BannerSummary;
            if (emotionSummary != null) {
                String str = "MicroMsg.emoji.EmojiStoreVpHeaderAdapter";
                String str2 = "productId %s";
                Object[] objArr = new Object[1];
                objArr[0] = emotionSummary == null ? "" : emotionSummary.ProductID;
                ab.d(str, str2, objArr);
                h.pYm.e(11929, Integer.valueOf(0));
                m.a(this.mContext, emotionSummary, 15, -1, -1, "", 8);
            }
        }
        AppMethodBeat.o(52772);
    }
}
