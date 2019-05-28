package com.tencent.p177mm.p612ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.kernel.C1720g;
import com.tencent.p177mm.model.C1855t;
import com.tencent.p177mm.p203bg.C1310f;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C30379h;
import com.tencent.p177mm.p837bh.C25859d;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.multitalk.model.C39419a;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.pluginsdk.p597ui.C40459a.C40460b;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C4996ah;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.mm.ui.MultiTalkRoomPopupNav */
public class MultiTalkRoomPopupNav extends LinearLayout {
    private LinearLayout yoK;
    private View yoL;
    private TextView yoM;
    private TextView yoN;
    private TextView yoO;
    private String yoP;
    private String yoQ;
    private boolean yoR;
    private C15476b yoS = C15476b.NotInTalking;
    private C23555a yoT;
    private final int yoU = 6;
    private LinearLayout yoV;
    public boolean yoW = false;
    private C1310f yoX = new C1310f();

    /* renamed from: com.tencent.mm.ui.MultiTalkRoomPopupNav$b */
    enum C15476b {
        Inviting,
        Talking,
        NotInTalking;

        static {
            AppMethodBeat.m2505o(29776);
        }
    }

    /* renamed from: com.tencent.mm.ui.MultiTalkRoomPopupNav$1 */
    class C235531 implements OnClickListener {
        C235531() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(29769);
            if (C25859d.fUu != null && ((C39419a) C1720g.m3528K(C39419a.class)).mo55126bJ(MultiTalkRoomPopupNav.this.getContext())) {
                C4990ab.m7410d("MicroMsg.MultiTalkRoomPopupNav", "is voip talking");
                AppMethodBeat.m2505o(29769);
            } else if (C25859d.fUu == null || !C25859d.fUu.akL()) {
                MultiTalkRoomPopupNav.m36383a(MultiTalkRoomPopupNav.this);
                AppMethodBeat.m2505o(29769);
            } else {
                Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.cdm), 0).show();
                C4990ab.m7410d("MicroMsg.MultiTalkRoomPopupNav", "is show loation");
                AppMethodBeat.m2505o(29769);
            }
        }
    }

    /* renamed from: com.tencent.mm.ui.MultiTalkRoomPopupNav$a */
    class C23555a {
        private Button lXI;
        TextView titleView;
        LinearLayout yoZ;

        /* synthetic */ C23555a(MultiTalkRoomPopupNav multiTalkRoomPopupNav, boolean z, byte b) {
            this(z);
        }

        private C23555a(boolean z) {
            AppMethodBeat.m2504i(29772);
            this.lXI = (Button) MultiTalkRoomPopupNav.this.findViewById(2131826245);
            this.titleView = (TextView) MultiTalkRoomPopupNav.this.findViewById(2131826241);
            this.yoZ = (LinearLayout) MultiTalkRoomPopupNav.this.findViewById(2131826240);
            if (z) {
                this.yoZ.setBackgroundResource(C25738R.drawable.f6928vn);
                this.lXI.setTextColor(MultiTalkRoomPopupNav.this.getResources().getColor(C25738R.color.f12192vi));
                AppMethodBeat.m2505o(29772);
                return;
            }
            this.yoZ.setBackgroundResource(C25738R.drawable.f6922vh);
            this.lXI.setTextColor(MultiTalkRoomPopupNav.this.getResources().getColor(C25738R.color.f11829im));
            AppMethodBeat.m2505o(29772);
        }

        /* Access modifiers changed, original: final */
        public final void close() {
            AppMethodBeat.m2504i(29773);
            this.yoZ.setVisibility(8);
            AppMethodBeat.m2505o(29773);
        }
    }

    @TargetApi(11)
    public MultiTalkRoomPopupNav(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        AppMethodBeat.m2504i(29777);
        initView();
        AppMethodBeat.m2505o(29777);
    }

    public MultiTalkRoomPopupNav(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        AppMethodBeat.m2504i(29778);
        initView();
        AppMethodBeat.m2505o(29778);
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

    public void setMultiTalkInfo(C1310f c1310f) {
        this.yoX = c1310f;
    }

    private void initView() {
        AppMethodBeat.m2504i(29779);
        MultiTalkRoomPopupNav.inflate(getContext(), 2130970267, this);
        this.yoK = (LinearLayout) findViewById(2131826235);
        this.yoL = findViewById(2131826234);
        this.yoM = (TextView) findViewById(2131826237);
        this.yoN = (TextView) findViewById(2131826238);
        this.yoO = (TextView) findViewById(2131826239);
        this.yoV = (LinearLayout) findViewById(2131826242);
        this.yoK.setOnClickListener(new C235531());
        AppMethodBeat.m2505o(29779);
    }

    /* renamed from: pV */
    public final void mo39224pV(boolean z) {
        AppMethodBeat.m2504i(29780);
        this.yoW = false;
        if (this.yoP == null || this.yoQ == null) {
            C4990ab.m7412e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + this.yoP + ",currentSenderUserName:" + this.yoQ);
            AppMethodBeat.m2505o(29780);
            return;
        }
        String str = this.yoP;
        if (((C39419a) C1720g.m3528K(C39419a.class)).mo55110RV(str)) {
            List RY = ((C39419a) C1720g.m3528K(C39419a.class)).mo55113RY(str);
            if (RY.size() == 0) {
                ((C39419a) C1720g.m3528K(C39419a.class)).mo55137pI(str);
                dyV();
                AppMethodBeat.m2505o(29780);
                return;
            }
            int fg = ((C39419a) C1720g.m3528K(C39419a.class)).mo55134fg(str, this.yoQ);
            if (fg == 1) {
                setUserTalkingStatus(C15476b.Inviting);
                if (((C39419a) C1720g.m3528K(C39419a.class)).mo55114RZ(str)) {
                    dyV();
                    AppMethodBeat.m2505o(29780);
                    return;
                }
                setInvitingBannerStyle(((C39419a) C1720g.m3528K(C39419a.class)).mo55136mJ(((C39419a) C1720g.m3528K(C39419a.class)).mo55135fh(str, this.yoQ)));
            } else if (fg == 10) {
                setUserTalkingStatus(C15476b.Talking);
                if (((C39419a) C1720g.m3528K(C39419a.class)).mo55114RZ(str)) {
                    dyV();
                    AppMethodBeat.m2505o(29780);
                    return;
                } else if (((C39419a) C1720g.m3528K(C39419a.class)).bRd()) {
                    dyV();
                    AppMethodBeat.m2505o(29780);
                    return;
                } else {
                    setUserTalkingStatus(C15476b.NotInTalking);
                    setDefaultBannerStyle(C4996ah.getContext().getString(C25738R.string.d38, new Object[]{Integer.valueOf(RY.size())}));
                }
            } else {
                setUserTalkingStatus(C15476b.NotInTalking);
                setDefaultBannerStyle(C4996ah.getContext().getString(C25738R.string.d38, new Object[]{Integer.valueOf(RY.size())}));
            }
            setVisibility(0);
            this.yoK.setVisibility(0);
            this.yoL.setVisibility(0);
            if (this.yoT != null && (z || this.yoV == null || this.yoV.getVisibility() != 0)) {
                this.yoT.close();
            }
            m36390eM(MultiTalkRoomPopupNav.m36394k(RY, ""));
            AppMethodBeat.m2505o(29780);
            return;
        }
        dyV();
        AppMethodBeat.m2505o(29780);
    }

    public void setUserTalkingStatus(C15476b c15476b) {
        this.yoS = c15476b;
    }

    private void setTalkingBannerStyle(String str) {
        AppMethodBeat.m2504i(29781);
        this.yoL.setBackgroundResource(C25738R.drawable.f6928vn);
        this.yoM.setTextColor(getResources().getColor(C25738R.color.f12194vk));
        this.yoM.setText(str);
        this.yoM.setVisibility(0);
        this.yoO.setVisibility(8);
        this.yoN.setVisibility(8);
        AppMethodBeat.m2505o(29781);
    }

    private void setInvitingBannerStyle(String str) {
        AppMethodBeat.m2504i(29782);
        this.yoL.setBackgroundResource(C25738R.drawable.f6928vn);
        this.yoN.setTextColor(getResources().getColor(C25738R.color.f12192vi));
        this.yoN.setText(str);
        this.yoM.setVisibility(8);
        this.yoO.setVisibility(0);
        this.yoN.setVisibility(0);
        this.yoV.setVisibility(8);
        AppMethodBeat.m2505o(29782);
    }

    private void setDefaultBannerStyle(String str) {
        AppMethodBeat.m2504i(29783);
        this.yoL.setBackgroundResource(C25738R.drawable.f6922vh);
        this.yoM.setTextColor(getResources().getColor(C25738R.color.f12192vi));
        this.yoM.setText(str);
        if (this.yoV == null || this.yoV.getVisibility() != 0) {
            this.yoM.setVisibility(0);
            this.yoO.setVisibility(8);
            this.yoN.setVisibility(8);
            this.yoV.setVisibility(8);
        }
        AppMethodBeat.m2505o(29783);
    }

    public final void dyV() {
        AppMethodBeat.m2504i(29784);
        this.yoW = false;
        setVisibility(8);
        if (this.yoT != null) {
            this.yoT.close();
        }
        AppMethodBeat.m2505o(29784);
    }

    /* renamed from: d */
    private void m36388d(String str, List<String> list, final String str2) {
        AppMethodBeat.m2504i(29785);
        this.yoL.setVisibility(8);
        this.yoK.setVisibility(8);
        this.yoT = new C23555a(this, this.yoS == C15476b.Inviting, (byte) 0);
        C23555a c23555a = this.yoT;
        C235522 c235522 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(29770);
                C4990ab.m7416i("MicroMsg.MultiTalkRoomPopupNav", "click enter button..");
                if (str2 != null) {
                    if (((C39419a) C1720g.m3528K(C39419a.class)).bRb()) {
                        C4990ab.m7412e("MicroMsg.MultiTalkRoomPopupNav", "now is in other voip..");
                        C30379h.m48461b(MultiTalkRoomPopupNav.this.getContext(), C4996ah.getContext().getString(C25738R.string.d2t), null, true);
                        AppMethodBeat.m2505o(29770);
                        return;
                    }
                    List RY = ((C39419a) C1720g.m3528K(C39419a.class)).mo55113RY(MultiTalkRoomPopupNav.this.yoP);
                    C7060h c7060h;
                    Object[] objArr;
                    int i;
                    if (RY.size() == 1) {
                        MultiTalkRoomPopupNav.aqH(str2);
                        C7060h.pYm.mo8381e(13945, Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(1), MultiTalkRoomPopupNav.this.yoP, Integer.valueOf(MultiTalkRoomPopupNav.this.yoX.field_roomId), Long.valueOf(MultiTalkRoomPopupNav.this.yoX.field_roomKey));
                    } else if (RY.size() >= 9) {
                        C4990ab.m7412e("MicroMsg.MultiTalkRoomPopupNav", "now is up to the limit,memberList size:" + RY.size());
                        C30379h.m48461b(MultiTalkRoomPopupNav.this.getContext(), C4996ah.getContext().getString(C25738R.string.d2x, new Object[]{Integer.valueOf(9)}), null, true);
                        c7060h = C7060h.pYm;
                        objArr = new Object[7];
                        objArr[0] = Integer.valueOf(1);
                        if (MultiTalkRoomPopupNav.this.yoS == C15476b.Inviting) {
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
                        c7060h.mo8381e(13945, objArr);
                        AppMethodBeat.m2505o(29770);
                        return;
                    } else if (((C39419a) C1720g.m3528K(C39419a.class)).bRa()) {
                        C4990ab.m7412e("MicroMsg.MultiTalkRoomPopupNav", "now is inviting other people voip..");
                        C30379h.m48461b(MultiTalkRoomPopupNav.this.getContext(), C4996ah.getContext().getString(C25738R.string.d2r), null, true);
                        c7060h = C7060h.pYm;
                        objArr = new Object[7];
                        objArr[0] = Integer.valueOf(1);
                        if (MultiTalkRoomPopupNav.this.yoS == C15476b.Inviting) {
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
                        c7060h.mo8381e(13945, objArr);
                        AppMethodBeat.m2505o(29770);
                        return;
                    } else {
                        MultiTalkRoomPopupNav.m36384a(MultiTalkRoomPopupNav.this, str2);
                    }
                }
                MultiTalkRoomPopupNav.this.yoT.close();
                MultiTalkRoomPopupNav.this.yoK.setVisibility(0);
                MultiTalkRoomPopupNav.this.yoL.setVisibility(0);
                MultiTalkRoomPopupNav.this.yoV.setVisibility(8);
                AppMethodBeat.m2505o(29770);
            }
        };
        C235543 c235543 = new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.m2504i(29771);
                C4990ab.m7416i("MicroMsg.MultiTalkRoomPopupNav", "click cancel button..");
                if (MultiTalkRoomPopupNav.this.yoS == C15476b.Inviting) {
                    C4990ab.m7416i("MicroMsg.MultiTalkRoomPopupNav", "reject multiTalk!");
                    boolean Sd = ((C39419a) C1720g.m3528K(C39419a.class)).mo55118Sd(str2);
                    ((C39419a) C1720g.m3528K(C39419a.class)).mo55119Se(str2);
                    C7060h c7060h = C7060h.pYm;
                    Object[] objArr = new Object[7];
                    objArr[0] = Integer.valueOf(3);
                    objArr[1] = Integer.valueOf(1);
                    objArr[2] = Integer.valueOf(0);
                    objArr[3] = Integer.valueOf(Sd ? 0 : 1);
                    objArr[4] = MultiTalkRoomPopupNav.this.yoP;
                    objArr[5] = Integer.valueOf(MultiTalkRoomPopupNav.this.yoX.field_roomId);
                    objArr[6] = Long.valueOf(MultiTalkRoomPopupNav.this.yoX.field_roomKey);
                    c7060h.mo8381e(13945, objArr);
                } else {
                    C7060h.pYm.mo8381e(13945, Integer.valueOf(2), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), MultiTalkRoomPopupNav.this.yoP, Integer.valueOf(MultiTalkRoomPopupNav.this.yoX.field_roomId), Long.valueOf(MultiTalkRoomPopupNav.this.yoX.field_roomKey));
                }
                MultiTalkRoomPopupNav.this.yoT.close();
                MultiTalkRoomPopupNav.this.yoK.setVisibility(0);
                MultiTalkRoomPopupNav.this.yoL.setVisibility(0);
                MultiTalkRoomPopupNav.this.yoV.setVisibility(8);
                AppMethodBeat.m2505o(29771);
            }
        };
        c23555a.titleView.setText(str);
        c23555a.yoZ.setVisibility(0);
        MultiTalkRoomPopupNav.this.yoV.setVisibility(0);
        MultiTalkRoomPopupNav.this.yoV.removeAllViews();
        for (String str3 : list) {
            ImageView imageView = new ImageView(MultiTalkRoomPopupNav.this.getContext());
            LayoutParams layoutParams = new LayoutParams(C1338a.fromDPToPix(C4996ah.getContext(), 26), C1338a.fromDPToPix(C4996ah.getContext(), 26));
            layoutParams.rightMargin = C1338a.fromDPToPix(C4996ah.getContext(), 10);
            imageView.setScaleType(ScaleType.FIT_CENTER);
            imageView.setLayoutParams(layoutParams);
            MultiTalkRoomPopupNav.this.yoV.addView(imageView);
            C40460b.m69434b(imageView, str3);
        }
        ((Button) MultiTalkRoomPopupNav.this.findViewById(2131826246)).setOnClickListener(c235522);
        ((Button) MultiTalkRoomPopupNav.this.findViewById(2131826245)).setOnClickListener(c235543);
        AppMethodBeat.m2505o(29785);
    }

    /* renamed from: eM */
    private void m36390eM(List<String> list) {
        AppMethodBeat.m2504i(29786);
        if (this.yoV != null && this.yoV.getVisibility() == 0) {
            this.yoV.removeAllViews();
            for (String str : list) {
                ImageView imageView = new ImageView(getContext());
                LayoutParams layoutParams = new LayoutParams(C1338a.fromDPToPix(C4996ah.getContext(), 26), C1338a.fromDPToPix(C4996ah.getContext(), 26));
                layoutParams.rightMargin = C1338a.fromDPToPix(C4996ah.getContext(), 10);
                imageView.setScaleType(ScaleType.FIT_CENTER);
                imageView.setLayoutParams(layoutParams);
                this.yoV.addView(imageView);
                C40460b.m69434b(imageView, str);
            }
        }
        AppMethodBeat.m2505o(29786);
    }

    /* renamed from: k */
    private static List<String> m36394k(List<String> list, String str) {
        AppMethodBeat.m2504i(29787);
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
        AppMethodBeat.m2505o(29787);
        return arrayList;
    }

    /* renamed from: a */
    static /* synthetic */ void m36383a(MultiTalkRoomPopupNav multiTalkRoomPopupNav) {
        int i = 0;
        AppMethodBeat.m2504i(29788);
        C7060h c7060h;
        Object[] objArr;
        int i2;
        if (multiTalkRoomPopupNav.yoP == null || multiTalkRoomPopupNav.yoQ == null) {
            C4990ab.m7412e("MicroMsg.MultiTalkRoomPopupNav", "groupUserName or currentSenderUserName is null! groupUserName:" + multiTalkRoomPopupNav.yoP + ",currentSenderUserName:" + multiTalkRoomPopupNav.yoQ);
            AppMethodBeat.m2505o(29788);
        } else if (!C1855t.m3896kH(multiTalkRoomPopupNav.yoP) || multiTalkRoomPopupNav.yoR) {
            String str = multiTalkRoomPopupNav.yoP;
            if (((C39419a) C1720g.m3528K(C39419a.class)).mo55110RV(str)) {
                List RY = ((C39419a) C1720g.m3528K(C39419a.class)).mo55113RY(str);
                if (RY.size() == 0) {
                    C4990ab.m7412e("MicroMsg.MultiTalkRoomPopupNav", "dealWithMultiTalkroomClick multiTalkMemberList is empty!");
                    C30379h.m48461b(multiTalkRoomPopupNav.getContext(), C4996ah.getContext().getString(C25738R.string.d3e), null, true);
                    multiTalkRoomPopupNav.dyV();
                    c7060h = C7060h.pYm;
                    objArr = new Object[7];
                    objArr[0] = Integer.valueOf(4);
                    if (multiTalkRoomPopupNav.yoS == C15476b.Inviting) {
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
                    c7060h.mo8381e(13945, objArr);
                    AppMethodBeat.m2505o(29788);
                    return;
                }
                if (RY.size() == 1) {
                    C4990ab.m7416i("MicroMsg.MultiTalkRoomPopupNav", "just one now member now! wait for back service process!");
                }
                String string;
                List k;
                if (multiTalkRoomPopupNav.yoS == C15476b.Talking) {
                    multiTalkRoomPopupNav.yoW = true;
                    Intent intent = new Intent();
                    intent.putExtra("enterMainUiSource", 2);
                    intent.putExtra("enterMainUiWxGroupId", str);
                    C25985d.m41467b(C4996ah.getContext(), "multitalk", ".ui.MultiTalkMainUI", intent);
                    c7060h = C7060h.pYm;
                    objArr = new Object[7];
                    objArr[0] = Integer.valueOf(4);
                    if (multiTalkRoomPopupNav.yoS == C15476b.Inviting) {
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
                    c7060h.mo8381e(13945, objArr);
                    AppMethodBeat.m2505o(29788);
                    return;
                } else if (multiTalkRoomPopupNav.yoS == C15476b.Inviting) {
                    if (((C39419a) C1720g.m3528K(C39419a.class)).mo55135fh(str, multiTalkRoomPopupNav.yoQ) != null) {
                        string = C4996ah.getContext().getString(C25738R.string.bda, new Object[]{((C39419a) C1720g.m3528K(C39419a.class)).mo55136mJ(r5)});
                        k = MultiTalkRoomPopupNav.m36394k(RY, multiTalkRoomPopupNav.yoQ);
                        RY.size();
                        multiTalkRoomPopupNav.m36388d(string, k, str);
                    }
                    c7060h = C7060h.pYm;
                    objArr = new Object[7];
                    objArr[0] = Integer.valueOf(4);
                    if (multiTalkRoomPopupNav.yoS == C15476b.Inviting) {
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
                    c7060h.mo8381e(13945, objArr);
                    AppMethodBeat.m2505o(29788);
                    return;
                } else if (((C39419a) C1720g.m3528K(C39419a.class)).bRb()) {
                    C30379h.m48461b(multiTalkRoomPopupNav.getContext(), C4996ah.getContext().getString(C25738R.string.d2t), null, true);
                    c7060h = C7060h.pYm;
                    objArr = new Object[7];
                    objArr[0] = Integer.valueOf(4);
                    if (multiTalkRoomPopupNav.yoS == C15476b.Inviting) {
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
                    c7060h.mo8381e(13945, objArr);
                    AppMethodBeat.m2505o(29788);
                    return;
                } else if (RY.size() >= 9) {
                    C30379h.m48461b(multiTalkRoomPopupNav.getContext(), C4996ah.getContext().getString(C25738R.string.d2x, new Object[]{Integer.valueOf(9)}), null, true);
                    C7060h c7060h2 = C7060h.pYm;
                    Object[] objArr2 = new Object[7];
                    objArr2[0] = Integer.valueOf(4);
                    if (multiTalkRoomPopupNav.yoS == C15476b.Inviting) {
                        i = 1;
                    }
                    objArr2[1] = Integer.valueOf(i);
                    objArr2[2] = Integer.valueOf(1);
                    objArr2[3] = Integer.valueOf(1);
                    objArr2[4] = multiTalkRoomPopupNav.yoP;
                    objArr2[5] = Integer.valueOf(multiTalkRoomPopupNav.yoX.field_roomId);
                    objArr2[6] = Long.valueOf(multiTalkRoomPopupNav.yoX.field_roomKey);
                    c7060h2.mo8381e(13945, objArr2);
                    AppMethodBeat.m2505o(29788);
                    return;
                } else {
                    string = C4996ah.getContext().getString(C25738R.string.d3p);
                    k = MultiTalkRoomPopupNav.m36394k(RY, "");
                    RY.size();
                    multiTalkRoomPopupNav.m36388d(string, k, str);
                    C7060h.pYm.mo8381e(13945, Integer.valueOf(4), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), multiTalkRoomPopupNav.yoP, Integer.valueOf(multiTalkRoomPopupNav.yoX.field_roomId), Long.valueOf(multiTalkRoomPopupNav.yoX.field_roomKey));
                    AppMethodBeat.m2505o(29788);
                    return;
                }
            }
            C4990ab.m7412e("MicroMsg.MultiTalkRoomPopupNav", "dealWithMultiTalkroomClick multiTalkInfo is null!");
            C30379h.m48461b(multiTalkRoomPopupNav.getContext(), C4996ah.getContext().getString(C25738R.string.d3e), null, true);
            multiTalkRoomPopupNav.dyV();
            c7060h = C7060h.pYm;
            objArr = new Object[7];
            objArr[0] = Integer.valueOf(4);
            if (multiTalkRoomPopupNav.yoS == C15476b.Inviting) {
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
            c7060h.mo8381e(13945, objArr);
            AppMethodBeat.m2505o(29788);
        } else {
            C30379h.m48461b(multiTalkRoomPopupNav.getContext(), C4996ah.getContext().getString(C25738R.string.d34), null, true);
            multiTalkRoomPopupNav.dyV();
            ((C39419a) C1720g.m3528K(C39419a.class)).mo55137pI(multiTalkRoomPopupNav.yoP);
            c7060h = C7060h.pYm;
            objArr = new Object[7];
            objArr[0] = Integer.valueOf(4);
            if (multiTalkRoomPopupNav.yoS == C15476b.Inviting) {
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
            c7060h.mo8381e(13945, objArr);
            AppMethodBeat.m2505o(29788);
        }
    }

    static /* synthetic */ void aqH(String str) {
        AppMethodBeat.m2504i(29789);
        C4990ab.m7416i("MicroMsg.MultiTalkRoomPopupNav", "when only on menber do clear banner!");
        ((C39419a) C1720g.m3528K(C39419a.class)).mo55117Sc(str);
        C4990ab.m7416i("MicroMsg.MultiTalkRoomPopupNav", "when only on member do exit talk!");
        if (!((C39419a) C1720g.m3528K(C39419a.class)).mo55115Sa(str)) {
            C4990ab.m7416i("MicroMsg.MultiTalkRoomPopupNav", "when only on member do exit talk failure! groupId:".concat(String.valueOf(str)));
        }
        AppMethodBeat.m2505o(29789);
    }

    /* renamed from: a */
    static /* synthetic */ void m36384a(MultiTalkRoomPopupNav multiTalkRoomPopupNav, String str) {
        AppMethodBeat.m2504i(29790);
        C4990ab.m7416i("MicroMsg.MultiTalkRoomPopupNav", "now try enter multitalk:".concat(String.valueOf(str)));
        C7060h c7060h;
        Object[] objArr;
        if (((C39419a) C1720g.m3528K(C39419a.class)).mo55116Sb(str)) {
            int i;
            ((C39419a) C1720g.m3528K(C39419a.class)).mo55119Se(str);
            c7060h = C7060h.pYm;
            objArr = new Object[7];
            objArr[0] = Integer.valueOf(1);
            if (multiTalkRoomPopupNav.yoS == C15476b.Inviting) {
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
            c7060h.mo8381e(13945, objArr);
            AppMethodBeat.m2505o(29790);
            return;
        }
        C4990ab.m7412e("MicroMsg.MultiTalkRoomPopupNav", "try enter fail!".concat(String.valueOf(str)));
        Toast.makeText(C4996ah.getContext(), C4996ah.getContext().getString(C25738R.string.d2e), 0).show();
        c7060h = C7060h.pYm;
        objArr = new Object[7];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = Integer.valueOf(multiTalkRoomPopupNav.yoS == C15476b.Inviting ? 1 : 0);
        objArr[2] = Integer.valueOf(0);
        objArr[3] = Integer.valueOf(1);
        objArr[4] = multiTalkRoomPopupNav.yoP;
        objArr[5] = Integer.valueOf(multiTalkRoomPopupNav.yoX.field_roomId);
        objArr[6] = Long.valueOf(multiTalkRoomPopupNav.yoX.field_roomKey);
        c7060h.mo8381e(13945, objArr);
        AppMethodBeat.m2505o(29790);
    }
}
