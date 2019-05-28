package com.tencent.mm.plugin.appbrand.ui.autofill;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.v;
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
import com.tencent.mm.R;
import com.tencent.mm.modelappbrand.a.b;
import com.tencent.mm.modelappbrand.a.f;
import com.tencent.mm.protocal.protobuf.bzo;
import com.tencent.mm.protocal.protobuf.ga;
import com.tencent.mm.protocal.protobuf.gb;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMFragment;
import java.util.List;

public class AppBrandIDCardShowFrag extends MMFragment {
    private LinearLayout eol;
    private TextView hrg;
    com.tencent.mm.plugin.appbrand.ui.autofill.AppBrandIDCardUI.a iJN;
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
    private com.tencent.mm.ui.a mActionBarHelper;

    public static class a extends android.support.v7.widget.RecyclerView.a<a> {
        private List<ga> iKa;

        public static class a extends v {
            public TextView gtb;
            public TextView iKb;

            public a(View view) {
                super(view);
                AppMethodBeat.i(133209);
                this.gtb = (TextView) view.findViewById(R.id.qx);
                this.iKb = (TextView) view.findViewById(R.id.qy);
                AppMethodBeat.o(133209);
            }
        }

        public a(List<ga> list) {
            this.iKa = list;
        }

        public final int getItemCount() {
            AppMethodBeat.i(133210);
            if (this.iKa == null) {
                AppMethodBeat.o(133210);
                return 0;
            }
            int size = this.iKa.size();
            AppMethodBeat.o(133210);
            return size;
        }
    }

    public void dealContentView(View view) {
        AppMethodBeat.i(133213);
        if (this.iJN == null || this.iJN.aMH() == null) {
            ab.e("MicroMsg.AppBrandIDCardShowFrag", "idCardUILogic or idCardUILogic.getIDCardShowInfo() is null, err");
            AppMethodBeat.o(133213);
            return;
        }
        this.eol = (LinearLayout) view.findViewById(R.id.qz);
        this.iyo = (ImageView) view.findViewById(R.id.r0);
        this.hrg = (TextView) view.findViewById(R.id.r1);
        this.iJP = (RecyclerView) view.findViewById(R.id.r3);
        this.iJQ = (TextView) view.findViewById(R.id.r4);
        this.iJR = (Button) view.findViewById(R.id.r7);
        this.iJS = (CheckBox) view.findViewById(R.id.r5);
        this.iJT = (TextView) view.findViewById(R.id.r6);
        this.iJU = (LinearLayout) view.findViewById(R.id.qw);
        this.iJV = view.findViewById(R.id.r9);
        this.iJW = (TextView) view.findViewById(R.id.r8);
        this.iJX = (TextView) view.findViewById(R.id.r_);
        this.iJO = com.tencent.mm.ui.v.hu(getContext()).inflate(R.layout.a_, null);
        this.iJO.setBackgroundColor(getResources().getColor(R.color.vy));
        this.mActionBarHelper = new com.tencent.mm.ui.a(this.iJO);
        this.eol.addView(this.iJO, 0, new LayoutParams(-1, com.tencent.mm.plugin.appbrand.widget.a.de(getActivity())));
        final bzo aMH = this.iJN.aMH();
        this.mActionBarHelper.setTitle(aMH.title);
        this.mActionBarHelper.b(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(133202);
                if (AppBrandIDCardShowFrag.this.iJN != null) {
                    AppBrandIDCardShowFrag.this.iJN.back();
                }
                AppMethodBeat.o(133202);
            }
        });
        b.abR().a(this.iyo, aMH.wIL, com.tencent.mm.modelappbrand.a.a.abQ(), f.fqH);
        this.hrg.setText(aMH.fhH + " " + aMH.wYC);
        if (aMH.wYD != null) {
            this.iJP.setVisibility(0);
            RecyclerView recyclerView = this.iJP;
            getContext();
            recyclerView.setLayoutManager(new LinearLayoutManager());
            this.iJP.setAdapter(new a(aMH.wYD));
        } else {
            ab.e("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.user_id_list is null");
            this.iJP.setVisibility(8);
        }
        this.iJQ.setText(aMH.wYE);
        if (bo.isNullOrNil(aMH.wYF)) {
            this.iJR.setText(getString(R.string.jh));
        } else {
            this.iJR.setText(aMH.wYF);
        }
        ab.i("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.auth_checked:%b", Boolean.valueOf(aMH.wYJ));
        this.iJS.setChecked(aMH.wYJ);
        this.iJR.setEnabled(aMH.wYJ);
        if (bo.isNullOrNil(aMH.wYK)) {
            this.iJS.setText(getString(R.string.ji));
        } else {
            this.iJS.setText(aMH.wYK);
        }
        this.iJS.setOnCheckedChangeListener(new OnCheckedChangeListener() {
            public final void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AppMethodBeat.i(133203);
                if (AppBrandIDCardShowFrag.this.iJR != null) {
                    AppBrandIDCardShowFrag.this.iJR.setEnabled(z);
                }
                AppMethodBeat.o(133203);
            }
        });
        this.iJR.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(133204);
                ab.i("MicroMsg.AppBrandIDCardShowFrag", "verifyPayPassword click");
                if (AppBrandIDCardShowFrag.this.iJN != null) {
                    AppBrandIDCardShowFrag.this.iJN.aMF();
                }
                AppMethodBeat.o(133204);
            }
        });
        if (aMH.wYG != null) {
            this.iJT.setText(aMH.wYG.name);
            this.iJT.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(133205);
                    if (AppBrandIDCardShowFrag.this.iJN != null) {
                        AppBrandIDCardShowFrag.this.iJN.DW(aMH.wYG.url);
                    }
                    AppMethodBeat.o(133205);
                }
            });
        }
        if (aMH.wYH != null) {
            ab.d("MicroMsg.AppBrandIDCardShowFrag", "idCardShowInfo.jump_list size:%d", Integer.valueOf(aMH.wYH.size()));
            if (aMH.wYH.size() == 0) {
                this.iJU.setVisibility(8);
                AppMethodBeat.o(133213);
                return;
            } else if (aMH.wYH.size() == 1) {
                this.iJU.setVisibility(0);
                this.iJV.setVisibility(8);
                this.iJX.setVisibility(8);
                if (aMH.wYH.get(0) != null) {
                    this.iJW.setText(((gb) aMH.wYH.get(0)).name);
                    this.iJW.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(133206);
                            if (AppBrandIDCardShowFrag.this.iJN != null) {
                                AppBrandIDCardShowFrag.this.iJN.DX(((gb) aMH.wYH.get(0)).url);
                            }
                            AppMethodBeat.o(133206);
                        }
                    });
                    AppMethodBeat.o(133213);
                    return;
                }
            } else {
                this.iJU.setVisibility(0);
                this.iJV.setVisibility(0);
                this.iJX.setVisibility(0);
                if (aMH.wYH.get(0) != null) {
                    this.iJW.setText(((gb) aMH.wYH.get(0)).name);
                    this.iJW.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(133207);
                            ab.i("MicroMsg.AppBrandIDCardShowFrag", "urlJump click");
                            if (AppBrandIDCardShowFrag.this.iJN != null) {
                                AppBrandIDCardShowFrag.this.iJN.DX(((gb) aMH.wYH.get(0)).url);
                            }
                            AppMethodBeat.o(133207);
                        }
                    });
                }
                if (aMH.wYH.get(1) != null) {
                    this.iJX.setText(((gb) aMH.wYH.get(1)).name);
                    this.iJX.setOnClickListener(new OnClickListener() {
                        public final void onClick(View view) {
                            AppMethodBeat.i(133208);
                            if (AppBrandIDCardShowFrag.this.iJN != null) {
                                AppBrandIDCardShowFrag.this.iJN.DY(((gb) aMH.wYH.get(1)).url);
                            }
                            AppMethodBeat.o(133208);
                        }
                    });
                }
            }
        }
        AppMethodBeat.o(133213);
    }

    public boolean noActionBar() {
        return true;
    }

    public boolean supportNavigationSwipeBack() {
        return false;
    }

    public int getLayoutId() {
        return R.layout.ca;
    }

    public void onSwipeBack() {
        AppMethodBeat.i(133214);
        if (this.iJN != null) {
            this.iJN.onSwipeBack();
        }
        AppMethodBeat.o(133214);
    }
}
