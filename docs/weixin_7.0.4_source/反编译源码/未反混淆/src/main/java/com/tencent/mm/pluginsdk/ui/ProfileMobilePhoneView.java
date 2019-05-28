package com.tencent.mm.pluginsdk.ui;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.k;
import com.tencent.smtt.sdk.WebView;
import java.util.List;
import junit.framework.Assert;

public class ProfileMobilePhoneView extends ProfileItemView {
    public TextView iDT;
    private Context mContext;
    public String vim;
    public String vin;
    public String[] vio;
    public LinearLayout vix;
    public boolean viy;

    static class a extends BaseAdapter {
        private Context mContext = null;
        private List<String> ngC = null;

        class a {
            TextView gsf;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }
        }

        public a(Context context, List<String> list) {
            AppMethodBeat.i(27534);
            Assert.assertTrue(context != null);
            this.mContext = context;
            this.ngC = list;
            AppMethodBeat.o(27534);
        }

        public final int getCount() {
            AppMethodBeat.i(27535);
            if (this.ngC == null) {
                AppMethodBeat.o(27535);
                return 0;
            }
            int size = this.ngC.size();
            AppMethodBeat.o(27535);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(27536);
            Object obj = this.ngC.get(i);
            AppMethodBeat.o(27536);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            Object obj;
            AppMethodBeat.i(27537);
            String str = (String) getItem(i);
            if (view == null) {
                view = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(R.layout.mx, viewGroup, false);
                a aVar = new a(this, (byte) 0);
                aVar.gsf = (TextView) view.findViewById(R.id.cx);
                view.setTag(aVar);
                obj = aVar;
            } else {
                obj = view.getTag();
            }
            ((a) obj).gsf.setText(str);
            AppMethodBeat.o(27537);
            return view;
        }
    }

    public ProfileMobilePhoneView(Context context) {
        this(context, null);
    }

    public ProfileMobilePhoneView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProfileMobilePhoneView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.viy = false;
        this.mContext = context;
    }

    public int getLayout() {
        return R.layout.alo;
    }

    public final void init() {
        AppMethodBeat.i(27538);
        this.iDT = (TextView) findViewById(R.id.dq8);
        this.vix = (LinearLayout) findViewById(R.id.dq9);
        for (int i = 0; i < 5; i++) {
            this.vix.getChildAt(i).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(27532);
                    ProfileMobilePhoneView.a(ProfileMobilePhoneView.this, ((TextView) view).getText().toString());
                    AppMethodBeat.o(27532);
                }
            });
        }
        AppMethodBeat.o(27538);
    }

    @Deprecated
    public final boolean T(ad adVar) {
        return false;
    }

    public final void hG(String str, String str2) {
        AppMethodBeat.i(27539);
        ab.i("MicroMsg.ProfileMobilePhoneView", "phoneNumberByMD5:%s phoneNumberList:%s", str, str2);
        this.vim = str;
        this.vin = str2;
        cby();
        AppMethodBeat.o(27539);
    }

    public final boolean cby() {
        AppMethodBeat.i(27540);
        if (this.iDT != null) {
            LayoutParams layoutParams = this.iDT.getLayoutParams();
            layoutParams.width = com.tencent.mm.bz.a.al(getContext(), R.dimen.i8);
            this.iDT.setLayoutParams(layoutParams);
        }
        if (this.vix == null) {
            AppMethodBeat.o(27540);
        } else {
            int i;
            int i2;
            View childAt;
            int i3;
            if (bo.isNullOrNil(this.vim) || !bo.ant(this.vim).booleanValue()) {
                if (!(this.vim == null || bo.ant(this.vim).booleanValue())) {
                    ab.e("MicroMsg.ProfileMobilePhoneView", "mobile format is error----%s", this.vim);
                }
                i = 0;
                i2 = 0;
            } else {
                childAt = this.vix.getChildAt(0);
                if (childAt != null) {
                    childAt.setVisibility(0);
                    ((TextView) childAt).setText(this.vim);
                }
                i = 1;
                i2 = 1;
            }
            if (!bo.isNullOrNil(this.vin)) {
                this.vio = this.vin.split(",");
                setVisibility(0);
                while (true) {
                    i3 = i2;
                    if (i3 >= this.vio.length + i) {
                        break;
                    }
                    childAt = this.vix.getChildAt(i3);
                    if (childAt != null) {
                        childAt.setVisibility(0);
                        ((TextView) childAt).setText(this.vio[i3 - i]);
                    }
                    i2 = i3 + 1;
                }
            } else {
                i3 = i2;
            }
            while (i3 < 5) {
                this.vix.getChildAt(i3).setVisibility(8);
                i3++;
            }
            if (i != 1 && bo.isNullOrNil(this.vin)) {
                setVisibility(8);
            }
            AppMethodBeat.o(27540);
        }
        return false;
    }

    static /* synthetic */ void a(ProfileMobilePhoneView profileMobilePhoneView, final String str) {
        AppMethodBeat.i(27541);
        final k kVar = new k(profileMobilePhoneView.mContext);
        kVar.khG = new a(profileMobilePhoneView.mContext, bo.P(!profileMobilePhoneView.viy ? new String[]{profileMobilePhoneView.mContext.getResources().getString(R.string.ang)} : new String[]{profileMobilePhoneView.mContext.getResources().getString(R.string.ang), profileMobilePhoneView.mContext.getResources().getString(R.string.anh)}));
        kVar.vtI = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(27533);
                if (kVar != null) {
                    kVar.dismiss();
                }
                Intent intent;
                if (i == 0) {
                    h hVar;
                    Integer[] numArr;
                    Object[] objArr;
                    int i2;
                    Integer[] numArr2;
                    Integer[] numArr3;
                    if (bo.isNullOrNil(ProfileMobilePhoneView.this.vim)) {
                        hVar = h.pYm;
                        numArr3 = new Object[1];
                        numArr = numArr3;
                        objArr = numArr3;
                    } else {
                        hVar = h.pYm;
                        numArr3 = new Object[1];
                        Integer[] numArr4;
                        if (ProfileMobilePhoneView.this.vim.equals(str.trim())) {
                            i2 = 1;
                            numArr2 = numArr3;
                            numArr4 = numArr3;
                            numArr2[0] = Integer.valueOf(i2);
                            hVar.e(12043, objArr);
                            intent = new Intent("android.intent.action.DIAL");
                            intent.setFlags(268435456);
                            intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
                            ProfileMobilePhoneView.this.getContext().startActivity(intent);
                            AppMethodBeat.o(27533);
                            return;
                        }
                        numArr = numArr3;
                        numArr4 = numArr3;
                    }
                    i2 = 0;
                    numArr2 = numArr;
                    numArr2[0] = Integer.valueOf(i2);
                    hVar.e(12043, objArr);
                    intent = new Intent("android.intent.action.DIAL");
                    intent.setFlags(268435456);
                    intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
                    try {
                        ProfileMobilePhoneView.this.getContext().startActivity(intent);
                        AppMethodBeat.o(27533);
                        return;
                    } catch (ActivityNotFoundException e) {
                        ab.printErrStackTrace("MicroMsg.ProfileMobilePhoneView", e, "Activity not found!", new Object[0]);
                        AppMethodBeat.o(27533);
                        return;
                    }
                }
                if (1 == i) {
                    h.pYm.e(12059, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    intent = new Intent();
                    intent.putExtra("IPCallTalkUI_phoneNumber", str);
                    d.b(ProfileMobilePhoneView.this.mContext, "ipcall", ".ui.IPCallDialUI", intent);
                }
                AppMethodBeat.o(27533);
            }
        };
        kVar.setCancelable(true);
        kVar.show();
        AppMethodBeat.o(27541);
    }
}
