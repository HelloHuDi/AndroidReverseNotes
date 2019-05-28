package com.tencent.mm.plugin.ipcall.ui;

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
import com.tencent.mm.R;
import com.tencent.mm.compatible.b.g;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.voip.video.d;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKConst;
import java.util.HashMap;
import java.util.Map;

public class DialPad extends RelativeLayout implements OnClickListener, OnLongClickListener {
    private static final String[] nzK = new String[]{"1", "2", TMQQDownloaderOpenSDKConst.VERIFYTYPE_ALL, "4", "5", "6", "7", "8", "9", "*", AppEventsConstants.EVENT_PARAM_VALUE_NO, "#"};
    private static final String[] nzL = new String[]{"", "ABC", "DEF", "GHI", "JKL", "MNO", "PQRS", "TUV", "WXYZ", "", "+", ""};
    private boolean nzJ = false;
    private Map<Integer, DialNumberButton> nzM = new HashMap();
    private Map<String, DialNumberButton> nzN = new HashMap();
    private Map<Integer, View> nzO = new HashMap();
    private a nzP;

    public interface a {
        void OX(String str);

        void OY(String str);
    }

    public DialPad(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(21959);
        init();
        AppMethodBeat.o(21959);
    }

    public void setDialButtonClickListener(a aVar) {
        this.nzP = aVar;
    }

    private void init() {
        AppMethodBeat.i(21960);
        LayoutInflater.from(getContext()).inflate(R.layout.sg, this);
        float dimensionPixelSize = (float) getContext().getResources().getDimensionPixelSize(R.dimen.v);
        float dimensionPixelSize2 = (float) getContext().getResources().getDimensionPixelSize(R.dimen.x);
        float dimensionPixelSize3 = (float) getContext().getResources().getDimensionPixelSize(R.dimen.w);
        a(R.id.b_9, nzK[0], nzL[0], dimensionPixelSize);
        a(R.id.b__, nzK[1], nzL[1], dimensionPixelSize);
        a(R.id.b_a, nzK[2], nzL[2], dimensionPixelSize);
        a(R.id.b_c, nzK[3], nzL[3], dimensionPixelSize);
        a(R.id.b_d, nzK[4], nzL[4], dimensionPixelSize);
        a(R.id.b_e, nzK[5], nzL[5], dimensionPixelSize);
        a(R.id.b_g, nzK[6], nzL[6], dimensionPixelSize);
        a(R.id.b_h, nzK[7], nzL[7], dimensionPixelSize);
        a(R.id.b_i, nzK[8], nzL[8], dimensionPixelSize);
        a(R.id.b_k, nzK[9], nzL[9], dimensionPixelSize3);
        a(R.id.b_l, nzK[10], nzL[10], dimensionPixelSize);
        a(R.id.b_m, nzK[11], nzL[11], dimensionPixelSize2);
        this.nzO.put(Integer.valueOf(R.id.b_3), findViewById(R.id.b_3));
        this.nzO.put(Integer.valueOf(R.id.b_4), findViewById(R.id.b_4));
        this.nzO.put(Integer.valueOf(R.id.b_5), findViewById(R.id.b_5));
        this.nzO.put(Integer.valueOf(R.id.b_6), findViewById(R.id.b_6));
        this.nzO.put(Integer.valueOf(R.id.b_7), findViewById(R.id.b_7));
        for (View view : this.nzO.values()) {
            if (this.nzJ) {
                view.setBackgroundDrawable(getResources().getDrawable(R.color.a2r));
            } else {
                view.setBackgroundDrawable(getResources().getDrawable(R.color.m5));
            }
        }
        setClipToPadding(false);
        setClipChildren(false);
        AppMethodBeat.o(21960);
    }

    private void a(int i, String str, String str2, float f) {
        AppMethodBeat.i(21961);
        DialNumberButton dialNumberButton = (DialNumberButton) findViewById(i);
        dialNumberButton.eK(str, str2);
        dialNumberButton.setNumberTextSize$255e752(f);
        dialNumberButton.setOnClickListener(this);
        dialNumberButton.setOnLongClickListener(this);
        dialNumberButton.setInTalkUIMode(this.nzJ);
        this.nzM.put(Integer.valueOf(i), dialNumberButton);
        this.nzN.put(str, dialNumberButton);
        AppMethodBeat.o(21961);
    }

    public void setTalkUIMode(boolean z) {
        AppMethodBeat.i(21962);
        this.nzJ = z;
        for (DialNumberButton inTalkUIMode : this.nzM.values()) {
            inTalkUIMode.setInTalkUIMode(z);
        }
        for (View view : this.nzO.values()) {
            if (this.nzJ) {
                view.setBackgroundDrawable(getResources().getDrawable(R.color.a2r));
            } else {
                view.setBackgroundDrawable(getResources().getDrawable(R.color.m5));
            }
        }
        AppMethodBeat.o(21962);
    }

    public void onClick(View view) {
        AppMethodBeat.i(21963);
        if (this.nzM.containsKey(Integer.valueOf(view.getId()))) {
            DialNumberButton dialNumberButton = (DialNumberButton) this.nzM.get(Integer.valueOf(view.getId()));
            String numberText = dialNumberButton.getNumberText();
            String otherText = dialNumberButton.getOtherText();
            d bHB = i.bHB();
            int acb = d.acb(numberText);
            if (acb != -1 && d.cLH()) {
                AudioManager audioManager = g.KK().eoY;
                if (audioManager == null) {
                    audioManager = (AudioManager) d.mContext.getSystemService(SlookAirButtonRecentMediaAdapter.AUDIO_TYPE);
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
                            AppMethodBeat.o(21963);
                        }
                    }
                }
            }
            if (this.nzP != null) {
                this.nzP.OX(!bo.isNullOrNil(numberText) ? numberText : otherText);
            }
        }
        AppMethodBeat.o(21963);
    }

    public boolean onLongClick(View view) {
        AppMethodBeat.i(21964);
        if (this.nzM.containsKey(Integer.valueOf(view.getId()))) {
            DialNumberButton dialNumberButton = (DialNumberButton) this.nzM.get(Integer.valueOf(view.getId()));
            String numberText = dialNumberButton.getNumberText();
            String otherText = dialNumberButton.getOtherText();
            if (this.nzP != null) {
                a aVar = this.nzP;
                if (!bo.isNullOrNil(numberText)) {
                    otherText = numberText;
                }
                aVar.OY(otherText);
            }
            AppMethodBeat.o(21964);
            return true;
        }
        AppMethodBeat.o(21964);
        return false;
    }

    public void onViewAdded(View view) {
        AppMethodBeat.i(21965);
        ab.i("MicroMsg.DialPad", "onViewAdded, class: %s", view.getClass().getSimpleName());
        AppMethodBeat.o(21965);
    }

    public void onViewRemoved(View view) {
        AppMethodBeat.i(21966);
        ab.i("MicroMsg.DialPad", "onViewRemoved, class: %s", view.getClass().getSimpleName());
        AppMethodBeat.o(21966);
    }
}
