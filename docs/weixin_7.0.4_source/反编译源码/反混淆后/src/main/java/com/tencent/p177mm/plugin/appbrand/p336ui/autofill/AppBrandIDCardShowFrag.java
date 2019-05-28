package com.tencent.p177mm.plugin.appbrand.p336ui.autofill;

import android.support.p069v7.widget.LinearLayoutManager;
import android.support.p069v7.widget.RecyclerView;
import android.support.p069v7.widget.RecyclerView.C41523a;
import android.support.p069v7.widget.RecyclerView.C41531v;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.modelappbrand.p873a.C32804a;
import com.tencent.p177mm.modelappbrand.p873a.C37926b;
import com.tencent.p177mm.modelappbrand.p873a.C42201f;
import com.tencent.p177mm.p612ui.C15481a;
import com.tencent.p177mm.p612ui.C5616v;
import com.tencent.p177mm.p612ui.MMFragment;
import com.tencent.p177mm.plugin.appbrand.p336ui.autofill.AppBrandIDCardUI.C10825a;
import com.tencent.p177mm.plugin.appbrand.widget.C33575a;
import com.tencent.p177mm.protocal.protobuf.C15342ga;
import com.tencent.p177mm.protocal.protobuf.C30185gb;
import com.tencent.p177mm.protocal.protobuf.bzo;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import java.util.List;

/* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag */
public class AppBrandIDCardShowFrag extends MMFragment {
    private LinearLayout eol;
    private TextView hrg;
    C10825a iJN;
    private View iJO;
    private RecyclerView iJP;
    private TextView iJQ;
    private Button iJR;
    private CheckBox iJS;
    private TextView iJT;
    private LinearLayout iJU;
    private View iJV;
    private TextView iJW;
    private TextView iJX;
    private ImageView iyo;
    private C15481a mActionBarHelper;

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag$a */
    public static class C10808a extends C41523a<C10809a> {
        private List<C15342ga> iKa;

        /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag$a$a */
        public static class C10809a extends C41531v {
            public TextView gtb;
            public TextView iKb;

            public C10809a(View view) {
                super(view);
                AppMethodBeat.m2504i(133209);
                this.gtb = (TextView) view.findViewById(2131821196);
                this.iKb = (TextView) view.findViewById(2131821197);
                AppMethodBeat.m2505o(133209);
            }
        }

        public C10808a(List<C15342ga> list) {
            this.iKa = list;
        }

        public final int getItemCount() {
            AppMethodBeat.m2504i(133210);
            if (this.iKa == null) {
                AppMethodBeat.m2505o(133210);
                return 0;
            }
            int size = this.iKa.size();
            AppMethodBeat.m2505o(133210);
            return size;
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag$1 */
    class C108101 implements OnClickListener {
        C108101() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(133202);
            if (AppBrandIDCardShowFrag.this.iJN != null) {
                AppBrandIDCardShowFrag.this.iJN.back();
            }
            AppMethodBeat.m2505o(133202);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag$3 */
    class C108113 implements OnClickListener {
        C108113() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(133204);
            C4990ab.m7416i("MicroMsg.AppBrandIDCardShowFrag", "verifyPayPassword click");
            if (AppBrandIDCardShowFrag.this.iJN != null) {
                AppBrandIDCardShowFrag.this.iJN.aMF();
            }
            AppMethodBeat.m2505o(133204);
        }
    }

    /* renamed from: com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardShowFrag$2 */
    class C108132 implements OnCheckedChangeListener {
        C108132() {
        }

        public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            AppMethodBeat.m2504i(133203);
            if (AppBrandIDCardShowFrag.this.iJR != null) {
                AppBrandIDCardShowFrag.this.iJR.setEnabled(z);
            }
            AppMethodBeat.m2505o(133203);
        }
    }

    public void dealContentView(View view) {
        AppMethodBeat.m2504i(133213);
        if (this.iJN == null || this.iJN.aMH() == null) {
            C4990ab.m7412e("MicroMsg.AppBrandIDCardShowFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
            AppMethodBeat.m2505o(133213);
            return;
        }
        this.eol = (LinearLayout) view.findViewById(2131821198);
        this.iyo = (ImageView) view.findViewById(2131821199);
        this.hrg = (TextView) view.findViewById(2131821200);
        this.iJP = (RecyclerView) view.findViewById(2131821202);
        this.iJQ = (TextView) view.findViewById(2131821203);
        this.iJR = (Button) view.findViewById(2131821206);
        this.iJS = (CheckBox) view.findViewById(2131821204);
        this.iJT = (TextView) view.findViewById(2131821205);
        this.iJU = (LinearLayout) view.findViewById(2131821195);
        this.iJV = view.findViewById(2131821208);
        this.iJW = (TextView) view.findViewById(2131821207);
        this.iJX = (TextView) view.findViewById(2131821209);
        this.iJO = C5616v.m8409hu(getContext()).inflate(2130968612, null);
        this.iJO.setBackgroundColor(getResources().getColor(C25738R.color.f12206vy));
        this.mActionBarHelper = new C15481a(this.iJO);
        this.eol.addView(this.iJO, 0, new LayoutParams(-1, C33575a.m54827de(getActivity())));
        final bzo aMH = this.iJN.aMH();
        this.mActionBarHelper.setTitle(aMH.title);
        this.mActionBarHelper.mo27555b(new C108101());
        C37926b.abR().mo60683a(this.iyo, aMH.wIL, C32804a.abQ(), C42201f.fqH);
        this.hrg.setText(aMH.fhH + " " + aMH.wYC);
        if (aMH.wYD != null) {
            this.iJP.setVisibility(0);
            RecyclerView recyclerView = this.iJP;
            getContext();
            recyclerView.setLayoutManager(new LinearLayoutManager());
            this.iJP.setAdapter(new C10808a(aMH.wYD));
        } else {
            C4990ab.m7412e("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.user_id_list is null");
            this.iJP.setVisibility(8);
        }
        this.iJQ.setText(aMH.wYE);
        if (C5046bo.isNullOrNil(aMH.wYF)) {
            this.iJR.setText(getString(C25738R.string.f8922jh));
        } else {
            this.iJR.setText(aMH.wYF);
        }
        C4990ab.m7417i("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.auth_checked:%b", Boolean.valueOf(aMH.wYJ));
        this.iJS.setChecked(aMH.wYJ);
        this.iJR.setEnabled(aMH.wYJ);
        if (C5046bo.isNullOrNil(aMH.wYK)) {
            this.iJS.setText(getString(C25738R.string.f8923ji));
        } else {
            this.iJS.setText(aMH.wYK);
        }
        this.iJS.setOnCheckedChangeListener(new C108132());
        this.iJR.setOnClickListener(new C108113());
        if (aMH.wYG != null) {
            this.iJT.setText(aMH.wYG.name);
            this.iJT.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.m2504i(133205);
                    if (AppBrandIDCardShowFrag.this.iJN != null) {
                        AppBrandIDCardShowFrag.this.iJN.mo22364DW(aMH.wYG.url);
                    }
                    AppMethodBeat.m2505o(133205);
                }
            });
        }
        if (aMH.wYH != null) {
            C4990ab.m7411d("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.jump_list size:%d", Integer.valueOf(aMH.wYH.size()));
            if (aMH.wYH.size() == 0) {
                this.iJU.setVisibility(8);
                AppMethodBeat.m2505o(133213);
                return;
            } else if (aMH.wYH.size() == 1) {
                this.iJU.setVisibility(0);
                this.iJV.setVisibility(8);
                this.iJX.setVisibility(8);
                if (aMH.wYH.get(0) != null) {
                    this.iJW.setText(((C30185gb) aMH.wYH.get(0)).name);
                    this.iJW.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(133206);
                            if (AppBrandIDCardShowFrag.this.iJN != null) {
                                AppBrandIDCardShowFrag.this.iJN.mo22365DX(((C30185gb) aMH.wYH.get(0)).url);
                            }
                            AppMethodBeat.m2505o(133206);
                        }
                    });
                    AppMethodBeat.m2505o(133213);
                    return;
                }
            } else {
                this.iJU.setVisibility(0);
                this.iJV.setVisibility(0);
                this.iJX.setVisibility(0);
                if (aMH.wYH.get(0) != null) {
                    this.iJW.setText(((C30185gb) aMH.wYH.get(0)).name);
                    this.iJW.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(133207);
                            C4990ab.m7416i("MicroMsg.AppBrandIDCardShowFrag", "urlJump click");
                            if (AppBrandIDCardShowFrag.this.iJN != null) {
                                AppBrandIDCardShowFrag.this.iJN.mo22365DX(((C30185gb) aMH.wYH.get(0)).url);
                            }
                            AppMethodBeat.m2505o(133207);
                        }
                    });
                }
                if (aMH.wYH.get(1) != null) {
                    this.iJX.setText(((C30185gb) aMH.wYH.get(1)).name);
                    this.iJX.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.m2504i(133208);
                            if (AppBrandIDCardShowFrag.this.iJN != null) {
                                AppBrandIDCardShowFrag.this.iJN.mo22366DY(((C30185gb) aMH.wYH.get(1)).url);
                            }
                            AppMethodBeat.m2505o(133208);
                        }
                    });
                }
            }
        }
        AppMethodBeat.m2505o(133213);
    }

    public boolean noActionBar() {
        return true;
    }

    public boolean supportNavigationSwipeBack() {
        return false;
    }

    public int getLayoutId() {
        return 2130968687;
    }

    public void onSwipeBack() {
        AppMethodBeat.m2504i(133214);
        if (this.iJN != null) {
            this.iJN.onSwipeBack();
        }
        AppMethodBeat.m2505o(133214);
    }
}
