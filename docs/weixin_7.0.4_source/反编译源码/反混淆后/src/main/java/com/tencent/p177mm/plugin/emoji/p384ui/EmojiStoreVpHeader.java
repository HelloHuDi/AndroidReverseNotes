package com.tencent.p177mm.plugin.emoji.p384ui;

import android.app.Activity;
import android.content.Context;
import android.os.Message;
import android.support.p057v4.view.ViewPager;
import android.support.p057v4.view.ViewPager.OnPageChangeListener;
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
import com.tencent.p177mm.p612ui.base.MMDotView;
import com.tencent.p177mm.plugin.emoji.model.C45859a;
import com.tencent.p177mm.plugin.emoji.p381a.C38872i;
import com.tencent.p177mm.protocal.protobuf.EmotionBanner;
import com.tencent.p177mm.protocal.protobuf.EmotionBannerSet;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.sdk.platformtools.C7306ak;
import java.util.Iterator;
import java.util.LinkedList;

/* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader */
public class EmojiStoreVpHeader extends LinearLayout implements OnPageChangeListener {
    private View jcl;
    private MMDotView jiG;
    private View kRR;
    private LinkedList<C45859a> lbQ;
    private C38872i lbR;
    private float lbS;
    private float lbT;
    private C20406a lbU;
    private volatile boolean lbV;
    private final int lbW = 5;
    private final int lbX = 0;
    /* renamed from: sq */
    private ViewPager f13688sq;

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader$a */
    class C20406a extends C7306ak {
        private C20406a() {
        }

        /* synthetic */ C20406a(EmojiStoreVpHeader emojiStoreVpHeader, byte b) {
            this();
        }

        public final void handleMessage(Message message) {
            AppMethodBeat.m2504i(53510);
            if (!EmojiStoreVpHeader.this.lbV && message.what != 0) {
                AppMethodBeat.m2505o(53510);
            } else if (EmojiStoreVpHeader.this.lbQ == null || EmojiStoreVpHeader.this.lbQ.size() <= 1) {
                C4990ab.m7420w("MicroMsg.emoji.EmojiStoreVpHeader", "list is null");
                AppMethodBeat.m2505o(53510);
            } else if (EmojiStoreVpHeader.this.lbR == null) {
                C4990ab.m7420w("MicroMsg.emoji.EmojiStoreVpHeader", "adapter is null");
                AppMethodBeat.m2505o(53510);
            } else {
                int currentItem = EmojiStoreVpHeader.this.f13688sq.getCurrentItem() + 1;
                if (currentItem >= EmojiStoreVpHeader.this.lbR.getCount()) {
                    currentItem = (EmojiStoreVpHeader.this.lbQ.size() * C38872i.kSE) / 2;
                }
                EmojiStoreVpHeader.this.f13688sq.setCurrentItem(currentItem);
                if (EmojiStoreVpHeader.this.lbV && EmojiStoreVpHeader.this.lbU != null) {
                    sendMessageDelayed(EmojiStoreVpHeader.this.lbU.obtainMessage(0), 5000);
                }
                AppMethodBeat.m2505o(53510);
            }
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader$1 */
    class C277621 implements Runnable {
        C277621() {
        }

        public final void run() {
            AppMethodBeat.m2504i(53508);
            if (!(EmojiStoreVpHeader.this.lbR == null || EmojiStoreVpHeader.this.lbQ == null)) {
                C38872i a = EmojiStoreVpHeader.this.lbR;
                LinkedList b = EmojiStoreVpHeader.this.lbQ;
                a.kSD.clear();
                a.kSD.addAll(b);
                a.notifyDataSetChanged();
            }
            AppMethodBeat.m2505o(53508);
        }
    }

    /* renamed from: com.tencent.mm.plugin.emoji.ui.EmojiStoreVpHeader$2 */
    class C277632 implements Runnable {
        C277632() {
        }

        public final void run() {
            AppMethodBeat.m2504i(53509);
            EmojiStoreVpHeader.m44110c(EmojiStoreVpHeader.this);
            AppMethodBeat.m2505o(53509);
        }
    }

    /* renamed from: c */
    static /* synthetic */ void m44110c(EmojiStoreVpHeader emojiStoreVpHeader) {
        AppMethodBeat.m2504i(53523);
        emojiStoreVpHeader.blR();
        AppMethodBeat.m2505o(53523);
    }

    public EmojiStoreVpHeader(Context context) {
        super(context);
        AppMethodBeat.m2504i(53511);
        setOrientation(1);
        AppMethodBeat.m2505o(53511);
    }

    public EmojiStoreVpHeader(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(53512);
        setOrientation(1);
        AppMethodBeat.m2505o(53512);
    }

    /* renamed from: db */
    public static int[] m44112db(Context context) {
        AppMethodBeat.m2504i(53513);
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
        AppMethodBeat.m2505o(53513);
        return iArr;
    }

    private synchronized void blQ() {
        AppMethodBeat.m2504i(53514);
        if (this.lbQ == null) {
            IllegalAccessError illegalAccessError = new IllegalAccessError("must has emoji baner list first");
            AppMethodBeat.m2505o(53514);
            throw illegalAccessError;
        }
        int i;
        if (this.jcl == null) {
            this.jcl = EmojiStoreVpHeader.inflate(getContext(), 2130969386, null);
            this.kRR = this.jcl.findViewById(2131823597);
            this.jiG = (MMDotView) this.jcl.findViewById(2131823599);
            this.f13688sq = (ViewPager) this.jcl.findViewById(2131823598);
            this.lbU = new C20406a(this, (byte) 0);
            i = ((EmojiStoreVpHeader.m44112db(getContext())[0] * 3) / 8) + 1;
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
        if (this.f13688sq == null || this.lbQ == null) {
            AppMethodBeat.m2505o(53514);
        } else if (this.lbQ.size() <= 0) {
            if (this.kRR != null) {
                this.kRR.setVisibility(8);
            }
            AppMethodBeat.m2505o(53514);
        } else {
            if (this.kRR != null) {
                this.kRR.setVisibility(0);
            }
            this.f13688sq.setOnPageChangeListener(this);
            if (this.lbR == null) {
                this.lbR = new C38872i(getContext(), this.lbQ);
                this.f13688sq.setAdapter(this.lbR);
                this.f13688sq.setOffscreenPageLimit(1);
                blR();
                AppMethodBeat.m2505o(53514);
            } else {
                post(new C277621());
                AppMethodBeat.m2505o(53514);
            }
        }
    }

    private void blR() {
        AppMethodBeat.m2504i(53515);
        if (this.f13688sq == null) {
            AppMethodBeat.m2505o(53515);
            return;
        }
        this.f13688sq.setCurrentItem((C38872i.kSE / 2) * this.lbQ.size(), false);
        AppMethodBeat.m2505o(53515);
    }

    public final void blS() {
        AppMethodBeat.m2504i(53516);
        if (this.lbU == null) {
            this.lbU = new C20406a(this, (byte) 0);
        }
        this.lbV = true;
        this.lbU.removeMessages(0);
        this.lbU.sendEmptyMessageDelayed(0, 5000);
        AppMethodBeat.m2505o(53516);
    }

    public final void blT() {
        AppMethodBeat.m2504i(53517);
        if (this.lbU == null) {
            AppMethodBeat.m2505o(53517);
            return;
        }
        this.lbV = false;
        this.lbU.removeMessages(0);
        AppMethodBeat.m2505o(53517);
    }

    public final void clear() {
        AppMethodBeat.m2504i(53518);
        if (this.lbR != null) {
            this.lbR.clear();
            this.lbR = null;
        }
        this.lbU = null;
        AppMethodBeat.m2505o(53518);
    }

    /* renamed from: d */
    public final void mo45597d(LinkedList<EmotionBanner> linkedList, LinkedList<EmotionBannerSet> linkedList2) {
        AppMethodBeat.m2504i(53519);
        if (linkedList == null) {
            AppMethodBeat.m2505o(53519);
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
            if (!(emotionBannerSet == null || emotionBannerSet.BannerImg == null || C5046bo.isNullOrNil(emotionBannerSet.BannerImg.StripUrl))) {
                this.lbQ.add(new C45859a(null, emotionBannerSet, true));
            }
        }
        it = linkedList.iterator();
        while (it.hasNext()) {
            EmotionBanner emotionBanner = (EmotionBanner) it.next();
            if (!(emotionBanner == null || emotionBanner.BannerImg == null || C5046bo.isNullOrNil(emotionBanner.BannerImg.StripUrl))) {
                this.lbQ.add(new C45859a(emotionBanner, null, false));
            }
        }
        blQ();
        AppMethodBeat.m2505o(53519);
    }

    public void onPageScrollStateChanged(int i) {
    }

    public void onPageScrolled(int i, float f, int i2) {
    }

    public void onPageSelected(int i) {
        AppMethodBeat.m2504i(53520);
        if (this.lbQ == null || this.lbQ.size() <= 1) {
            AppMethodBeat.m2505o(53520);
            return;
        }
        if (i == 0 || i == this.lbR.getCount() - 1) {
            this.jcl.postDelayed(new C277632(), 350);
        }
        AppMethodBeat.m2505o(53520);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        AppMethodBeat.m2504i(53521);
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
                m44115gq(false);
                break;
            case 2:
                if (Math.abs((int) (rawX - this.lbS)) > Math.abs((int) (rawY - this.lbT))) {
                    m44115gq(true);
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
        AppMethodBeat.m2505o(53521);
        return onInterceptTouchEvent;
    }

    /* renamed from: gq */
    private void m44115gq(boolean z) {
        AppMethodBeat.m2504i(53522);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(z);
        }
        AppMethodBeat.m2505o(53522);
    }
}
