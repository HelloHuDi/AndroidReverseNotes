package com.tencent.p177mm.plugin.ipcall.p442ui;

import android.content.Context;
import android.media.AudioManager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.RelativeLayout;
import com.facebook.appevents.AppEventsConstants;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonRecentMediaAdapter;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.compatible.p219b.C1407g;
import com.tencent.p177mm.plugin.ipcall.p438a.C21088i;
import com.tencent.p177mm.plugin.voip.video.C43738d;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.tencent.mm.plugin.ipcall.ui.DialPad */
public class DialPad extends RelativeLayout implements OnClickListener, OnLongClickListener {
    private static final String[] nzK = new String[]{"1", "2", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "4", "5", "6", "7", "8", "9", "*", AppEventsConstants.EVENT_PARAM_VALUE_NO, "#"};
    private static final String[] nzL = new String[]{"", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", "", "+", ""};
    private boolean nzJ = false;
    private Map<Integer, DialNumberButton> nzM = new HashMap();
    private Map<String, DialNumberButton> nzN = new HashMap();
    private Map<Integer, View> nzO = new HashMap();
    private C34384a nzP;

    /* renamed from: com.tencent.mm.plugin.ipcall.ui.DialPad$a */
    public interface C34384a {
        /* renamed from: OX */
        void mo24177OX(String str);

        /* renamed from: OY */
        void mo24178OY(String str);
    }

    public DialPad(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(21959);
        init();
        AppMethodBeat.m2505o(21959);
    }

    public void setDialButtonClickListener(C34384a c34384a) {
        this.nzP = c34384a;
    }

    private void init() {
        AppMethodBeat.m2504i(21960);
        LayoutInflater.from(getContext()).inflate(2130969287, this);
        float dimensionPixelSize = (float) getContext().getResources().getDimensionPixelSize(C25738R.dimen.f9638v);
        float dimensionPixelSize2 = (float) getContext().getResources().getDimensionPixelSize(C25738R.dimen.f9640x);
        float dimensionPixelSize3 = (float) getContext().getResources().getDimensionPixelSize(C25738R.dimen.f9639w);
        m76874a(2131823291, nzK[0], nzL[0], dimensionPixelSize);
        m76874a(2131823292, nzK[1], nzL[1], dimensionPixelSize);
        m76874a(2131823293, nzK[2], nzL[2], dimensionPixelSize);
        m76874a(2131823295, nzK[3], nzL[3], dimensionPixelSize);
        m76874a(2131823296, nzK[4], nzL[4], dimensionPixelSize);
        m76874a(2131823297, nzK[5], nzL[5], dimensionPixelSize);
        m76874a(2131823299, nzK[6], nzL[6], dimensionPixelSize);
        m76874a(2131823300, nzK[7], nzL[7], dimensionPixelSize);
        m76874a(2131823301, nzK[8], nzL[8], dimensionPixelSize);
        m76874a(2131823303, nzK[9], nzL[9], dimensionPixelSize3);
        m76874a(2131823304, nzK[10], nzL[10], dimensionPixelSize);
        m76874a(2131823305, nzK[11], nzL[11], dimensionPixelSize2);
        this.nzO.put(Integer.valueOf(2131823285), findViewById(2131823285));
        this.nzO.put(Integer.valueOf(2131823286), findViewById(2131823286));
        this.nzO.put(Integer.valueOf(2131823287), findViewById(2131823287));
        this.nzO.put(Integer.valueOf(2131823288), findViewById(2131823288));
        this.nzO.put(Integer.valueOf(2131823289), findViewById(2131823289));
        for (View view : this.nzO.values()) {
            if (this.nzJ) {
                view.setBackgroundDrawable(getResources().getDrawable(C25738R.color.a2r));
            } else {
                view.setBackgroundDrawable(getResources().getDrawable(C25738R.color.f11933m5));
            }
        }
        setClipToPadding(false);
        setClipChildren(false);
        AppMethodBeat.m2505o(21960);
    }

    /* renamed from: a */
    private void m76874a(int i, String str, String str2, float f) {
        AppMethodBeat.m2504i(21961);
        DialNumberButton dialNumberButton = (DialNumberButton) findViewById(i);
        dialNumberButton.mo46269eK(str, str2);
        dialNumberButton.setNumberTextSize$255e752(f);
        dialNumberButton.setOnClickListener(this);
        dialNumberButton.setOnLongClickListener(this);
        dialNumberButton.setInTalkUIMode(this.nzJ);
        this.nzM.put(Integer.valueOf(i), dialNumberButton);
        this.nzN.put(str, dialNumberButton);
        AppMethodBeat.m2505o(21961);
    }

    public void setTalkUIMode(boolean z) {
        AppMethodBeat.m2504i(21962);
        this.nzJ = z;
        for (DialNumberButton inTalkUIMode : this.nzM.values()) {
            inTalkUIMode.setInTalkUIMode(z);
        }
        for (View view : this.nzO.values()) {
            if (this.nzJ) {
                view.setBackgroundDrawable(getResources().getDrawable(C25738R.color.a2r));
            } else {
                view.setBackgroundDrawable(getResources().getDrawable(C25738R.color.f11933m5));
            }
        }
        AppMethodBeat.m2505o(21962);
    }

    public void onClick(View view) {
        AppMethodBeat.m2504i(21963);
        if (this.nzM.containsKey(Integer.valueOf(view.getId()))) {
            DialNumberButton dialNumberButton = (DialNumberButton) this.nzM.get(Integer.valueOf(view.getId()));
            String numberText = dialNumberButton.getNumberText();
            String otherText = dialNumberButton.getOtherText();
            C43738d bHB = C21088i.bHB();
            int acb = C43738d.acb(numberText);
            if (acb != -1 && C43738d.cLH()) {
                AudioManager audioManager = C1407g.m2946KK().eoY;
                if (audioManager == null) {
                    audioManager = (AudioManager) C43738d.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
                }
                int ringerMode = audioManager.getRingerMode();
                if (!(ringerMode == 0 || ringerMode == 1)) {
                    synchronized (bHB.sZS) {
                        try {
                            if (bHB.sZT == null) {
                            } else {
                                bHB.sZT.startTone(acb, 250);
                            }
                        } catch (Throwable th) {
                            AppMethodBeat.m2505o(21963);
                        }
                    }
                }
            }
            if (this.nzP != null) {
                this.nzP.mo24177OX(!C5046bo.isNullOrNil(numberText) ? numberText : otherText);
            }
        }
        AppMethodBeat.m2505o(21963);
    }

    public boolean onLongClick(View view) {
        AppMethodBeat.m2504i(21964);
        if (this.nzM.containsKey(Integer.valueOf(view.getId()))) {
            DialNumberButton dialNumberButton = (DialNumberButton) this.nzM.get(Integer.valueOf(view.getId()));
            String numberText = dialNumberButton.getNumberText();
            String otherText = dialNumberButton.getOtherText();
            if (this.nzP != null) {
                C34384a c34384a = this.nzP;
                if (!C5046bo.isNullOrNil(numberText)) {
                    otherText = numberText;
                }
                c34384a.mo24178OY(otherText);
            }
            AppMethodBeat.m2505o(21964);
            return true;
        }
        AppMethodBeat.m2505o(21964);
        return false;
    }

    public void onViewAdded(View view) {
        AppMethodBeat.m2504i(21965);
        C4990ab.m7417i("MicroMsg.DialPad", "onViewAdded, class: %s", view.getClass().getSimpleName());
        AppMethodBeat.m2505o(21965);
    }

    public void onViewRemoved(View view) {
        AppMethodBeat.m2504i(21966);
        C4990ab.m7417i("MicroMsg.DialPad", "onViewRemoved, class: %s", view.getClass().getSimpleName());
        AppMethodBeat.m2505o(21966);
    }
}
