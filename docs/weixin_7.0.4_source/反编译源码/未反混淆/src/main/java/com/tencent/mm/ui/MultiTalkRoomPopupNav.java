package com.tencent.mm.ui;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bg.f;
import com.tencent.mm.bh.d;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.ui.base.h;
import java.util.ArrayList;
import java.util.List;

public class MultiTalkRoomPopupNav extends LinearLayout {
    private LinearLayout yoK;
    private View yoL;
    private TextView yoM;
    private TextView yoN;
    private TextView yoO;
    private String yoP;
    private String yoQ;
    private boolean yoR;
    private b yoS = b.NotInTalking;
    private a yoT;
    private final int yoU = 6;
    private LinearLayout yoV;
    public boolean yoW = false;
    private f yoX = new f();

    enum b {
        Inviting,
        Talking,
        NotInTalking;

        static {
            AppMethodBeat.o(29776);
        }
    }

    class a {
        private Button lXI;
        TextView titleView;
        LinearLayout yoZ;

        /* synthetic */ a(MultiTalkRoomPopupNav multiTalkRoomPopupNav, boolean z, byte b) {
            this(z);
        }

        private a(boolean z) {
            AppMethodBeat.i(29772);
            this.lXI = (Button) MultiTalkRoomPopupNav.this.findViewById(R.id.df4);
            this.titleView = (TextView) MultiTalkRoomPopupNav.this.findViewById(R.id.df0);
            this.yoZ = (LinearLayout) MultiTalkRoomPopupNav.this.findViewById(R.id.dez);
            if (z) {
                this.yoZ.setBackgroundResource(R.drawable.vn);
                this.lXI.setTextColor(MultiTalkRoomPopupNav.this.getResources().getColor(R.color.vi));
                AppMethodBeat.o(29772);
                return;
            }
            this.yoZ.setBackgroundResource(R.drawable.vh);
            this.lXI.setTextColor(MultiTalkRoomPopupNav.this.getResources().getColor(R.color.im));
            AppMethodBeat.o(29772);
        }

        /* Access modifiers changed, original: final */
        public final void close() {
            AppMethodBeat.i(29773);
            this.yoZ.setVisibility(8);
            AppMethodBeat.o(29773);
        }
    }

    @TargetApi(11)
    public MultiTalkRoomPopupNav(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.i(29777);
        initView();
        AppMethodBeat.o(29777);
    }

    public MultiTalkRoomPopupNav(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.i(29778);
        initView();
        AppMethodBeat.o(29778);
    }

    public void setGroupUserName(String str) {
        this.yoP = str;
    }

    public void setCurrentSenderUserName(String str) {
        this.yoQ = str;
    }

    public void setInChatRoom(boolean z) {
        this.yoR = z;
    }

    public void setMultiTalkInfo(f fVar) {
        this.yoX = fVar;
    }

    private void initView() {
        AppMethodBeat.i(29779);
        inflate(getContext(), R.layout.ahw, this);
        this.yoK = (LinearLayout) findViewById(R.id.deu);
        this.yoL = findViewById(R.id.det);
        this.yoM = (TextView) findViewById(R.id.dew);
        this.yoN = (TextView) findViewById(R.id.dex);
        this.yoO = (TextView) findViewById(R.id.dey);
        this.yoV = (LinearLayout) findViewById(R.id.df1);
        this.yoK.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(29769);
                if (d.fUu != null && ((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).bJ(MultiTalkRoomPopupNav.this.getContext())) {
                    ab.d("MicroMsg.MultiTalkRoomPopupNav", "is voip talking");
                    AppMethodBeat.o(29769);
                } else if (d.fUu == null || !d.fUu.akL()) {
                    MultiTalkRoomPopupNav.a(MultiTalkRoomPopupNav.this);
                    AppMethodBeat.o(29769);
                } else {
                    Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.cdm), 0).show();
                    ab.d("MicroMsg.MultiTalkRoomPopupNav", "is show loation");
                    AppMethodBeat.o(29769);
                }
            }
        });
        AppMethodBeat.o(29779);
    }

    public final void pV(boolean z) {
        AppMethodBeat.i(29780);
        this.yoW = false;
        if (this.yoP == null || this.yoQ == null) {
            ab.e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + this.yoP + ",currentSenderUserName:" + this.yoQ);
            AppMethodBeat.o(29780);
            return;
        }
        String str = this.yoP;
        if (((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).RV(str)) {
            List RY = ((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).RY(str);
            if (RY.size() == 0) {
                ((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).pI(str);
                dyV();
                AppMethodBeat.o(29780);
                return;
            }
            int fg = ((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).fg(str, this.yoQ);
            if (fg == 1) {
                setUserTalkingStatus(b.Inviting);
                if (((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).RZ(str)) {
                    dyV();
                    AppMethodBeat.o(29780);
                    return;
                }
                setInvitingBannerStyle(((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).mJ(((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).fh(str, this.yoQ)));
            } else if (fg == 10) {
                setUserTalkingStatus(b.Talking);
                if (((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).RZ(str)) {
                    dyV();
                    AppMethodBeat.o(29780);
                    return;
                } else if (((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).bRd()) {
                    dyV();
                    AppMethodBeat.o(29780);
                    return;
                } else {
                    setUserTalkingStatus(b.NotInTalking);
                    setDefaultBannerStyle(ah.getContext().getString(R.string.d38, new Object[]{Integer.valueOf(RY.size())}));
                }
            } else {
                setUserTalkingStatus(b.NotInTalking);
                setDefaultBannerStyle(ah.getContext().getString(R.string.d38, new Object[]{Integer.valueOf(RY.size())}));
            }
            setVisibility(0);
            this.yoK.setVisibility(0);
            this.yoL.setVisibility(0);
            if (this.yoT != null && (z || this.yoV == null || this.yoV.getVisibility() != 0)) {
                this.yoT.close();
            }
            eM(k(RY, ""));
            AppMethodBeat.o(29780);
            return;
        }
        dyV();
        AppMethodBeat.o(29780);
    }

    public void setUserTalkingStatus(b bVar) {
        this.yoS = bVar;
    }

    private void setTalkingBannerStyle(String str) {
        AppMethodBeat.i(29781);
        this.yoL.setBackgroundResource(R.drawable.vn);
        this.yoM.setTextColor(getResources().getColor(R.color.vk));
        this.yoM.setText(str);
        this.yoM.setVisibility(0);
        this.yoO.setVisibility(8);
        this.yoN.setVisibility(8);
        AppMethodBeat.o(29781);
    }

    private void setInvitingBannerStyle(String str) {
        AppMethodBeat.i(29782);
        this.yoL.setBackgroundResource(R.drawable.vn);
        this.yoN.setTextColor(getResources().getColor(R.color.vi));
        this.yoN.setText(str);
        this.yoM.setVisibility(8);
        this.yoO.setVisibility(0);
        this.yoN.setVisibility(0);
        this.yoV.setVisibility(8);
        AppMethodBeat.o(29782);
    }

    private void setDefaultBannerStyle(String str) {
        AppMethodBeat.i(29783);
        this.yoL.setBackgroundResource(R.drawable.vh);
        this.yoM.setTextColor(getResources().getColor(R.color.vi));
        this.yoM.setText(str);
        if (this.yoV == null || this.yoV.getVisibility() != 0) {
            this.yoM.setVisibility(0);
            this.yoO.setVisibility(8);
            this.yoN.setVisibility(8);
            this.yoV.setVisibility(8);
        }
        AppMethodBeat.o(29783);
    }

    public final void dyV() {
        AppMethodBeat.i(29784);
        this.yoW = false;
        setVisibility(8);
        if (this.yoT != null) {
            this.yoT.close();
        }
        AppMethodBeat.o(29784);
    }

    private void d(String str, List<String> list, final String str2) {
        AppMethodBeat.i(29785);
        this.yoL.setVisibility(8);
        this.yoK.setVisibility(8);
        this.yoT = new a(this, this.yoS == b.Inviting, (byte) 0);
        a aVar = this.yoT;
        AnonymousClass2 anonymousClass2 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(29770);
                ab.i("MicroMsg.MultiTalkRoomPopupNav", "click enter button..");
                if (str2 != null) {
                    if (((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).bRb()) {
                        ab.e("MicroMsg.MultiTalkRoomPopupNav", "now is in other voip..");
                        h.b(MultiTalkRoomPopupNav.this.getContext(), ah.getContext().getString(R.string.d2t), null, true);
                        AppMethodBeat.o(29770);
                        return;
                    }
                    List RY = ((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).RY(MultiTalkRoomPopupNav.this.yoP);
                    com.tencent.mm.plugin.report.service.h hVar;
                    Object[] objArr;
                    int i;
                    if (RY.size() == 1) {
                        MultiTalkRoomPopupNav.aqH(str2);
                        com.tencent.mm.plugin.report.service.h.pYm.e(13945, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), MultiTalkRoomPopupNav.this.yoP, Integer.valueOf(MultiTalkRoomPopupNav.this.yoX.field_roomId), Long.valueOf(MultiTalkRoomPopupNav.this.yoX.field_roomKey));
                    } else if (RY.size() >= 9) {
                        ab.e("MicroMsg.MultiTalkRoomPopupNav", "now is up to the limit,memberList size:" + RY.size());
                        h.b(MultiTalkRoomPopupNav.this.getContext(), ah.getContext().getString(R.string.d2x, new Object[]{Integer.valueOf(9)}), null, true);
                        hVar = com.tencent.mm.plugin.report.service.h.pYm;
                        objArr = new Object[7];
                        objArr[0] = Integer.valueOf(1);
                        if (MultiTalkRoomPopupNav.this.yoS == b.Inviting) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        objArr[1] = Integer.valueOf(i);
                        objArr[2] = Integer.valueOf(1);
                        objArr[3] = Integer.valueOf(1);
                        objArr[4] = MultiTalkRoomPopupNav.this.yoP;
                        objArr[5] = Integer.valueOf(MultiTalkRoomPopupNav.this.yoX.field_roomId);
                        objArr[6] = Long.valueOf(MultiTalkRoomPopupNav.this.yoX.field_roomKey);
                        hVar.e(13945, objArr);
                        AppMethodBeat.o(29770);
                        return;
                    } else if (((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).bRa()) {
                        ab.e("MicroMsg.MultiTalkRoomPopupNav", "now is inviting other people voip..");
                        h.b(MultiTalkRoomPopupNav.this.getContext(), ah.getContext().getString(R.string.d2r), null, true);
                        hVar = com.tencent.mm.plugin.report.service.h.pYm;
                        objArr = new Object[7];
                        objArr[0] = Integer.valueOf(1);
                        if (MultiTalkRoomPopupNav.this.yoS == b.Inviting) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        objArr[1] = Integer.valueOf(i);
                        objArr[2] = Integer.valueOf(0);
                        objArr[3] = Integer.valueOf(1);
                        objArr[4] = MultiTalkRoomPopupNav.this.yoP;
                        objArr[5] = Integer.valueOf(MultiTalkRoomPopupNav.this.yoX.field_roomId);
                        objArr[6] = Long.valueOf(MultiTalkRoomPopupNav.this.yoX.field_roomKey);
                        hVar.e(13945, objArr);
                        AppMethodBeat.o(29770);
                        return;
                    } else {
                        MultiTalkRoomPopupNav.a(MultiTalkRoomPopupNav.this, str2);
                    }
                }
                MultiTalkRoomPopupNav.this.yoT.close();
                MultiTalkRoomPopupNav.this.yoK.setVisibility(0);
                MultiTalkRoomPopupNav.this.yoL.setVisibility(0);
                MultiTalkRoomPopupNav.this.yoV.setVisibility(8);
                AppMethodBeat.o(29770);
            }
        };
        AnonymousClass3 anonymousClass3 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(29771);
                ab.i("MicroMsg.MultiTalkRoomPopupNav", "click cancel button..");
                if (MultiTalkRoomPopupNav.this.yoS == b.Inviting) {
                    ab.i("MicroMsg.MultiTalkRoomPopupNav", "reject multiTalk!");
                    boolean Sd = ((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).Sd(str2);
                    ((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).Se(str2);
                    com.tencent.mm.plugin.report.service.h hVar = com.tencent.mm.plugin.report.service.h.pYm;
                    Object[] objArr = new Object[7];
                    objArr[0] = Integer.valueOf(3);
                    objArr[1] = Integer.valueOf(1);
                    objArr[2] = Integer.valueOf(0);
                    objArr[3] = Integer.valueOf(Sd ? 0 : 1);
                    objArr[4] = MultiTalkRoomPopupNav.this.yoP;
                    objArr[5] = Integer.valueOf(MultiTalkRoomPopupNav.this.yoX.field_roomId);
                    objArr[6] = Long.valueOf(MultiTalkRoomPopupNav.this.yoX.field_roomKey);
                    hVar.e(13945, objArr);
                } else {
                    com.tencent.mm.plugin.report.service.h.pYm.e(13945, Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), MultiTalkRoomPopupNav.this.yoP, Integer.valueOf(MultiTalkRoomPopupNav.this.yoX.field_roomId), Long.valueOf(MultiTalkRoomPopupNav.this.yoX.field_roomKey));
                }
                MultiTalkRoomPopupNav.this.yoT.close();
                MultiTalkRoomPopupNav.this.yoK.setVisibility(0);
                MultiTalkRoomPopupNav.this.yoL.setVisibility(0);
                MultiTalkRoomPopupNav.this.yoV.setVisibility(8);
                AppMethodBeat.o(29771);
            }
        };
        aVar.titleView.setText(str);
        aVar.yoZ.setVisibility(0);
        MultiTalkRoomPopupNav.this.yoV.setVisibility(0);
        MultiTalkRoomPopupNav.this.yoV.removeAllViews();
        for (String str3 : list) {
            ImageView imageView = new ImageView(MultiTalkRoomPopupNav.this.getContext());
            LayoutParams layoutParams = new LayoutParams(com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 26), com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 26));
            layoutParams.rightMargin = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 10);
            imageView.setScaleType(ScaleType.FIT_CENTER);
            imageView.setLayoutParams(layoutParams);
            MultiTalkRoomPopupNav.this.yoV.addView(imageView);
            com.tencent.mm.pluginsdk.ui.a.b.b(imageView, str3);
        }
        ((Button) MultiTalkRoomPopupNav.this.findViewById(R.id.df5)).setOnClickListener(anonymousClass2);
        ((Button) MultiTalkRoomPopupNav.this.findViewById(R.id.df4)).setOnClickListener(anonymousClass3);
        AppMethodBeat.o(29785);
    }

    private void eM(List<String> list) {
        AppMethodBeat.i(29786);
        if (this.yoV != null && this.yoV.getVisibility() == 0) {
            this.yoV.removeAllViews();
            for (String str : list) {
                ImageView imageView = new ImageView(getContext());
                LayoutParams layoutParams = new LayoutParams(com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 26), com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 26));
                layoutParams.rightMargin = com.tencent.mm.bz.a.fromDPToPix(ah.getContext(), 10);
                imageView.setScaleType(ScaleType.FIT_CENTER);
                imageView.setLayoutParams(layoutParams);
                this.yoV.addView(imageView);
                com.tencent.mm.pluginsdk.ui.a.b.b(imageView, str);
            }
        }
        AppMethodBeat.o(29786);
    }

    private static List<String> k(List<String> list, String str) {
        AppMethodBeat.i(29787);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        if (!(str == null || str == "")) {
            for (String str2 : list) {
                if (!(str2 == null || str2.equals(str))) {
                    arrayList2.add(str2);
                }
            }
            List list2 = arrayList2;
        }
        for (String str22 : list2) {
            arrayList.add(str22);
        }
        AppMethodBeat.o(29787);
        return arrayList;
    }

    static /* synthetic */ void a(MultiTalkRoomPopupNav multiTalkRoomPopupNav) {
        int i = 0;
        AppMethodBeat.i(29788);
        com.tencent.mm.plugin.report.service.h hVar;
        Object[] objArr;
        int i2;
        if (multiTalkRoomPopupNav.yoP == null || multiTalkRoomPopupNav.yoQ == null) {
            ab.e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + multiTalkRoomPopupNav.yoP + ",currentSenderUserName:" + multiTalkRoomPopupNav.yoQ);
            AppMethodBeat.o(29788);
        } else if (!t.kH(multiTalkRoomPopupNav.yoP) || multiTalkRoomPopupNav.yoR) {
            String str = multiTalkRoomPopupNav.yoP;
            if (((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).RV(str)) {
                List RY = ((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).RY(str);
                if (RY.size() == 0) {
                    ab.e("MicroMsg.MultiTalkRoomPopupNav", "dealWithMultiTalkroomClick multiTalkMemberList is empty!");
                    h.b(multiTalkRoomPopupNav.getContext(), ah.getContext().getString(R.string.d3e), null, true);
                    multiTalkRoomPopupNav.dyV();
                    hVar = com.tencent.mm.plugin.report.service.h.pYm;
                    objArr = new Object[7];
                    objArr[0] = Integer.valueOf(4);
                    if (multiTalkRoomPopupNav.yoS == b.Inviting) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    objArr[1] = Integer.valueOf(i2);
                    objArr[2] = Integer.valueOf(0);
                    objArr[3] = Integer.valueOf(1);
                    objArr[4] = multiTalkRoomPopupNav.yoP;
                    objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.yoX.field_roomId);
                    objArr[6] = Long.valueOf(multiTalkRoomPopupNav.yoX.field_roomKey);
                    hVar.e(13945, objArr);
                    AppMethodBeat.o(29788);
                    return;
                }
                if (RY.size() == 1) {
                    ab.i("MicroMsg.MultiTalkRoomPopupNav", "just one now member now! wait for back service process!");
                }
                String string;
                List k;
                if (multiTalkRoomPopupNav.yoS == b.Talking) {
                    multiTalkRoomPopupNav.yoW = true;
                    Intent intent = new Intent();
                    intent.putExtra("enterMainUiSource", 2);
                    intent.putExtra("enterMainUiWxGroupId", str);
                    com.tencent.mm.bp.d.b(ah.getContext(), "multitalk", ".ui.MultiTalkMainUI", intent);
                    hVar = com.tencent.mm.plugin.report.service.h.pYm;
                    objArr = new Object[7];
                    objArr[0] = Integer.valueOf(4);
                    if (multiTalkRoomPopupNav.yoS == b.Inviting) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    objArr[1] = Integer.valueOf(i2);
                    objArr[2] = Integer.valueOf(0);
                    objArr[3] = Integer.valueOf(0);
                    objArr[4] = multiTalkRoomPopupNav.yoP;
                    objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.yoX.field_roomId);
                    objArr[6] = Long.valueOf(multiTalkRoomPopupNav.yoX.field_roomKey);
                    hVar.e(13945, objArr);
                    AppMethodBeat.o(29788);
                    return;
                } else if (multiTalkRoomPopupNav.yoS == b.Inviting) {
                    if (((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).fh(str, multiTalkRoomPopupNav.yoQ) != null) {
                        string = ah.getContext().getString(R.string.bda, new Object[]{((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).mJ(r5)});
                        k = k(RY, multiTalkRoomPopupNav.yoQ);
                        RY.size();
                        multiTalkRoomPopupNav.d(string, k, str);
                    }
                    hVar = com.tencent.mm.plugin.report.service.h.pYm;
                    objArr = new Object[7];
                    objArr[0] = Integer.valueOf(4);
                    if (multiTalkRoomPopupNav.yoS == b.Inviting) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    objArr[1] = Integer.valueOf(i2);
                    objArr[2] = Integer.valueOf(0);
                    objArr[3] = Integer.valueOf(0);
                    objArr[4] = multiTalkRoomPopupNav.yoP;
                    objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.yoX.field_roomId);
                    objArr[6] = Long.valueOf(multiTalkRoomPopupNav.yoX.field_roomKey);
                    hVar.e(13945, objArr);
                    AppMethodBeat.o(29788);
                    return;
                } else if (((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).bRb()) {
                    h.b(multiTalkRoomPopupNav.getContext(), ah.getContext().getString(R.string.d2t), null, true);
                    hVar = com.tencent.mm.plugin.report.service.h.pYm;
                    objArr = new Object[7];
                    objArr[0] = Integer.valueOf(4);
                    if (multiTalkRoomPopupNav.yoS == b.Inviting) {
                        i2 = 1;
                    } else {
                        i2 = 0;
                    }
                    objArr[1] = Integer.valueOf(i2);
                    objArr[2] = Integer.valueOf(0);
                    objArr[3] = Integer.valueOf(1);
                    objArr[4] = multiTalkRoomPopupNav.yoP;
                    objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.yoX.field_roomId);
                    objArr[6] = Long.valueOf(multiTalkRoomPopupNav.yoX.field_roomKey);
                    hVar.e(13945, objArr);
                    AppMethodBeat.o(29788);
                    return;
                } else if (RY.size() >= 9) {
                    h.b(multiTalkRoomPopupNav.getContext(), ah.getContext().getString(R.string.d2x, new Object[]{Integer.valueOf(9)}), null, true);
                    com.tencent.mm.plugin.report.service.h hVar2 = com.tencent.mm.plugin.report.service.h.pYm;
                    Object[] objArr2 = new Object[7];
                    objArr2[0] = Integer.valueOf(4);
                    if (multiTalkRoomPopupNav.yoS == b.Inviting) {
                        i = 1;
                    }
                    objArr2[1] = Integer.valueOf(i);
                    objArr2[2] = Integer.valueOf(1);
                    objArr2[3] = Integer.valueOf(1);
                    objArr2[4] = multiTalkRoomPopupNav.yoP;
                    objArr2[5] = Integer.valueOf(multiTalkRoomPopupNav.yoX.field_roomId);
                    objArr2[6] = Long.valueOf(multiTalkRoomPopupNav.yoX.field_roomKey);
                    hVar2.e(13945, objArr2);
                    AppMethodBeat.o(29788);
                    return;
                } else {
                    string = ah.getContext().getString(R.string.d3p);
                    k = k(RY, "");
                    RY.size();
                    multiTalkRoomPopupNav.d(string, k, str);
                    com.tencent.mm.plugin.report.service.h.pYm.e(13945, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), multiTalkRoomPopupNav.yoP, Integer.valueOf(multiTalkRoomPopupNav.yoX.field_roomId), Long.valueOf(multiTalkRoomPopupNav.yoX.field_roomKey));
                    AppMethodBeat.o(29788);
                    return;
                }
            }
            ab.e("MicroMsg.MultiTalkRoomPopupNav", "dealWithMultiTalkroomClick multiTalkInfo is null!");
            h.b(multiTalkRoomPopupNav.getContext(), ah.getContext().getString(R.string.d3e), null, true);
            multiTalkRoomPopupNav.dyV();
            hVar = com.tencent.mm.plugin.report.service.h.pYm;
            objArr = new Object[7];
            objArr[0] = Integer.valueOf(4);
            if (multiTalkRoomPopupNav.yoS == b.Inviting) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(1);
            objArr[4] = multiTalkRoomPopupNav.yoP;
            objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.yoX.field_roomId);
            objArr[6] = Long.valueOf(multiTalkRoomPopupNav.yoX.field_roomKey);
            hVar.e(13945, objArr);
            AppMethodBeat.o(29788);
        } else {
            h.b(multiTalkRoomPopupNav.getContext(), ah.getContext().getString(R.string.d34), null, true);
            multiTalkRoomPopupNav.dyV();
            ((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).pI(multiTalkRoomPopupNav.yoP);
            hVar = com.tencent.mm.plugin.report.service.h.pYm;
            objArr = new Object[7];
            objArr[0] = Integer.valueOf(4);
            if (multiTalkRoomPopupNav.yoS == b.Inviting) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(1);
            objArr[4] = multiTalkRoomPopupNav.yoP;
            objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.yoX.field_roomId);
            objArr[6] = Long.valueOf(multiTalkRoomPopupNav.yoX.field_roomKey);
            hVar.e(13945, objArr);
            AppMethodBeat.o(29788);
        }
    }

    static /* synthetic */ void aqH(String str) {
        AppMethodBeat.i(29789);
        ab.i("MicroMsg.MultiTalkRoomPopupNav", "when only on menber do clear banner!");
        ((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).Sc(str);
        ab.i("MicroMsg.MultiTalkRoomPopupNav", "when only on member do exit talk!");
        if (!((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).Sa(str)) {
            ab.i("MicroMsg.MultiTalkRoomPopupNav", "when only on member do exit talk failure! groupId:".concat(String.valueOf(str)));
        }
        AppMethodBeat.o(29789);
    }

    static /* synthetic */ void a(MultiTalkRoomPopupNav multiTalkRoomPopupNav, String str) {
        AppMethodBeat.i(29790);
        ab.i("MicroMsg.MultiTalkRoomPopupNav", "now try enter multitalk:".concat(String.valueOf(str)));
        com.tencent.mm.plugin.report.service.h hVar;
        Object[] objArr;
        if (((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).Sb(str)) {
            int i;
            ((com.tencent.mm.plugin.multitalk.model.a) g.K(com.tencent.mm.plugin.multitalk.model.a.class)).Se(str);
            hVar = com.tencent.mm.plugin.report.service.h.pYm;
            objArr = new Object[7];
            objArr[0] = Integer.valueOf(1);
            if (multiTalkRoomPopupNav.yoS == b.Inviting) {
                i = 1;
            } else {
                i = 0;
            }
            objArr[1] = Integer.valueOf(i);
            objArr[2] = Integer.valueOf(0);
            objArr[3] = Integer.valueOf(0);
            objArr[4] = multiTalkRoomPopupNav.yoP;
            objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.yoX.field_roomId);
            objArr[6] = Long.valueOf(multiTalkRoomPopupNav.yoX.field_roomKey);
            hVar.e(13945, objArr);
            AppMethodBeat.o(29790);
            return;
        }
        ab.e("MicroMsg.MultiTalkRoomPopupNav", "try enter fail!".concat(String.valueOf(str)));
        Toast.makeText(ah.getContext(), ah.getContext().getString(R.string.d2e), 0).show();
        hVar = com.tencent.mm.plugin.report.service.h.pYm;
        objArr = new Object[7];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.yoS == b.Inviting ? 1 : 0);
        objArr[2] = Integer.valueOf(0);
        objArr[3] = Integer.valueOf(1);
        objArr[4] = multiTalkRoomPopupNav.yoP;
        objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.yoX.field_roomId);
        objArr[6] = Long.valueOf(multiTalkRoomPopupNav.yoX.field_roomKey);
        hVar.e(13945, objArr);
        AppMethodBeat.o(29790);
    }
}
