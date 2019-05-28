package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.plugin.emoji.a.i;
import com.tencent.mm.protocal.protobuf.EmotionBanner;
import com.tencent.mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.MMDotView;
import java.util.Iterator;
import java.util.LinkedList;

public class EmojiStoreVpHeader extends LinearLayout implements OnPageChangeListener {
    private View jcl;
    private MMDotView jiG;
    private View kRR;
    private LinkedList<com.tencent.mm.plugin.emoji.model.a> lbQ;
    private i lbR;
    private float lbS;
    private float lbT;
    private a lbU;
    private volatile boolean lbV;
    private final int lbW = 5;
    private final int lbX = 0;
    private ViewPager sq;

    class a extends ak {
        private a() {
        }

        /* synthetic */ a(EmojiStoreVpHeader emojiStoreVpHeader, byte b) {
            this();
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.i(53510);
            if (!EmojiStoreVpHeader.this.lbV && message.what != 0) {
                AppMethodBeat.o(53510);
            } else if (EmojiStoreVpHeader.this.lbQ == null || EmojiStoreVpHeader.this.lbQ.size() <= 1) {
                ab.w("MicroMsg.emoji.EmojiStoreVpHeader", "list is null");
                AppMethodBeat.o(53510);
            } else if (EmojiStoreVpHeader.this.lbR == null) {
                ab.w("MicroMsg.emoji.EmojiStoreVpHeader", "adapter is null");
                AppMethodBeat.o(53510);
            } else {
                int currentItem = EmojiStoreVpHeader.this.sq.getCurrentItem() + 1;
                if (currentItem >= EmojiStoreVpHeader.this.lbR.getCount()) {
                    currentItem = (EmojiStoreVpHeader.this.lbQ.size() * i.kSE) / 2;
                }
                EmojiStoreVpHeader.this.sq.setCurrentItem(currentItem);
                if (EmojiStoreVpHeader.this.lbV && EmojiStoreVpHeader.this.lbU != null) {
                    sendMessageDelayed(EmojiStoreVpHeader.this.lbU.obtainMessage(0), 5000);
                }
                AppMethodBeat.o(53510);
            }
        }
    }

    static /* synthetic */ void c(EmojiStoreVpHeader emojiStoreVpHeader) {
        AppMethodBeat.i(53523);
        emojiStoreVpHeader.blR();
        AppMethodBeat.o(53523);
    }

    public EmojiStoreVpHeader(Context context) {
        super(context);
        AppMethodBeat.i(53511);
        setOrientation(1);
        AppMethodBeat.o(53511);
    }

    public EmojiStoreVpHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(53512);
        setOrientation(1);
        AppMethodBeat.o(53512);
    }

    public static int[] db(Context context) {
        AppMethodBeat.i(53513);
        int[] iArr = new int[2];
        if (context instanceof Activity) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) context).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            iArr[0] = displayMetrics.widthPixels;
            iArr[1] = displayMetrics.heightPixels;
        } else {
            Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
            iArr[0] = defaultDisplay.getWidth();
            iArr[1] = defaultDisplay.getHeight();
        }
        AppMethodBeat.o(53513);
        return iArr;
    }

    private synchronized void blQ() {
        AppMethodBeat.i(53514);
        if (this.lbQ == null) {
            IllegalAccessError illegalAccessError = new IllegalAccessError("must has emoji baner list first");
            AppMethodBeat.o(53514);
            throw illegalAccessError;
        }
        int i;
        if (this.jcl == null) {
            this.jcl = inflate(getContext(), R.layout.v5, null);
            this.kRR = this.jcl.findViewById(R.id.bhi);
            this.jiG = (MMDotView) this.jcl.findViewById(R.id.bhk);
            this.sq = (ViewPager) this.jcl.findViewById(R.id.bhj);
            this.lbU = new a(this, (byte) 0);
            i = ((db(getContext())[0] * 3) / 8) + 1;
            if (this.kRR != null) {
                this.kRR.setLayoutParams(new LayoutParams(-1, i));
            }
            addView(this.jcl, new LayoutParams(-1, -2));
        }
        if (this.jiG != null) {
            MMDotView mMDotView = this.jiG;
            if (this.lbQ == null) {
                i = 0;
            } else {
                i = this.lbQ.size();
            }
            mMDotView.setDotCount(i);
            this.jiG.setSelectedDot(0);
            this.jiG.setVisibility(8);
        }
        if (this.sq == null || this.lbQ == null) {
            AppMethodBeat.o(53514);
        } else if (this.lbQ.size() <= 0) {
            if (this.kRR != null) {
                this.kRR.setVisibility(8);
            }
            AppMethodBeat.o(53514);
        } else {
            if (this.kRR != null) {
                this.kRR.setVisibility(0);
            }
            this.sq.setOnPageChangeListener(this);
            if (this.lbR == null) {
                this.lbR = new i(getContext(), this.lbQ);
                this.sq.setAdapter(this.lbR);
                this.sq.setOffscreenPageLimit(1);
                blR();
                AppMethodBeat.o(53514);
            } else {
                post(new Runnable() {
                    public final void run() {
                        AppMethodBeat.i(53508);
                        if (!(EmojiStoreVpHeader.this.lbR == null || EmojiStoreVpHeader.this.lbQ == null)) {
                            i a = EmojiStoreVpHeader.this.lbR;
                            LinkedList b = EmojiStoreVpHeader.this.lbQ;
                            a.kSD.clear();
                            a.kSD.addAll(b);
                            a.notifyDataSetChanged();
                        }
                        AppMethodBeat.o(53508);
                    }
                });
                AppMethodBeat.o(53514);
            }
        }
    }

    private void blR() {
        AppMethodBeat.i(53515);
        if (this.sq == null) {
            AppMethodBeat.o(53515);
            return;
        }
        this.sq.setCurrentItem((i.kSE / 2) * this.lbQ.size(), false);
        AppMethodBeat.o(53515);
    }

    public final void blS() {
        AppMethodBeat.i(53516);
        if (this.lbU == null) {
            this.lbU = new a(this, (byte) 0);
        }
        this.lbV = true;
        this.lbU.removeMessages(0);
        this.lbU.sendEmptyMessageDelayed(0, 5000);
        AppMethodBeat.o(53516);
    }

    public final void blT() {
        AppMethodBeat.i(53517);
        if (this.lbU == null) {
            AppMethodBeat.o(53517);
            return;
        }
        this.lbV = false;
        this.lbU.removeMessages(0);
        AppMethodBeat.o(53517);
    }

    public final void clear() {
        AppMethodBeat.i(53518);
        if (this.lbR != null) {
            this.lbR.clear();
            this.lbR = null;
        }
        this.lbU = null;
        AppMethodBeat.o(53518);
    }

    public final void d(LinkedList<EmotionBanner> linkedList, LinkedList<EmotionBannerSet> linkedList2) {
        AppMethodBeat.i(53519);
        if (linkedList == null) {
            AppMethodBeat.o(53519);
            return;
        }
        if (this.lbQ == null) {
            this.lbQ = new LinkedList();
        } else {
            this.lbQ.clear();
        }
        Iterator it = linkedList2.iterator();
        while (it.hasNext()) {
            EmotionBannerSet emotionBannerSet = (EmotionBannerSet) it.next();
            if (!(emotionBannerSet == null || emotionBannerSet.BannerImg == null || bo.isNullOrNil(emotionBannerSet.BannerImg.StripUrl))) {
                this.lbQ.add(new com.tencent.mm.plugin.emoji.model.a(null, emotionBannerSet, true));
            }
        }
        it = linkedList.iterator();
        while (it.hasNext()) {
            EmotionBanner emotionBanner = (EmotionBanner) it.next();
            if (!(emotionBanner == null || emotionBanner.BannerImg == null || bo.isNullOrNil(emotionBanner.BannerImg.StripUrl))) {
                this.lbQ.add(new com.tencent.mm.plugin.emoji.model.a(emotionBanner, null, false));
            }
        }
        blQ();
        AppMethodBeat.o(53519);
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        AppMethodBeat.i(53520);
        if (this.lbQ == null || this.lbQ.size() <= 1) {
            AppMethodBeat.o(53520);
            return;
        }
        if (i == 0 || i == this.lbR.getCount() - 1) {
            this.jcl.postDelayed(new Runnable() {
                public final void run() {
                    AppMethodBeat.i(53509);
                    EmojiStoreVpHeader.c(EmojiStoreVpHeader.this);
                    AppMethodBeat.o(53509);
                }
            }, 350);
        }
        AppMethodBeat.o(53520);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.i(53521);
        int action = motionEvent.getAction();
        int action2 = motionEvent.getAction();
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        switch (action2) {
            case 0:
                this.lbS = rawX;
                this.lbT = rawY;
                break;
            case 1:
            case 3:
                this.lbS = 0.0f;
                this.lbT = 0.0f;
                gq(false);
                break;
            case 2:
                if (Math.abs((int) (rawX - this.lbS)) > Math.abs((int) (rawY - this.lbT))) {
                    gq(true);
                    break;
                }
                break;
        }
        switch (action) {
            case 0:
                blT();
                break;
            case 1:
            case 3:
                blS();
                break;
        }
        boolean onInterceptTouchEvent = super.onInterceptTouchEvent(motionEvent);
        AppMethodBeat.o(53521);
        return onInterceptTouchEvent;
    }

    private void gq(boolean z) {
        AppMethodBeat.i(53522);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
        AppMethodBeat.o(53522);
    }
}
