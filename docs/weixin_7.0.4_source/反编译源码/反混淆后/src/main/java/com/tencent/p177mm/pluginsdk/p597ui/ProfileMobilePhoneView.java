package com.tencent.p177mm.pluginsdk.p597ui;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.p208bz.C1338a;
import com.tencent.p177mm.p612ui.base.C30394k;
import com.tencent.p177mm.p842bp.C25985d;
import com.tencent.p177mm.plugin.report.service.C7060h;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
import com.tencent.p177mm.storage.C7616ad;
import com.tencent.smtt.sdk.WebView;
import java.util.List;
import junit.framework.Assert;

/* renamed from: com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView */
public class ProfileMobilePhoneView extends ProfileItemView {
    public TextView iDT;
    private Context mContext;
    public String vim;
    public String vin;
    public String[] vio;
    public LinearLayout vix;
    public boolean viy;

    /* renamed from: com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView$a */
    static class C23261a extends BaseAdapter {
        private Context mContext = null;
        private List<String> ngC = null;

        /* renamed from: com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView$a$a */
        class C23262a {
            TextView gsf;

            private C23262a() {
            }

            /* synthetic */ C23262a(C23261a c23261a, byte b) {
                this();
            }
        }

        public C23261a(Context context, List<String> list) {
            AppMethodBeat.m2504i(27534);
            Assert.assertTrue(context != null);
            this.mContext = context;
            this.ngC = list;
            AppMethodBeat.m2505o(27534);
        }

        public final int getCount() {
            AppMethodBeat.m2504i(27535);
            if (this.ngC == null) {
                AppMethodBeat.m2505o(27535);
                return 0;
            }
            int size = this.ngC.size();
            AppMethodBeat.m2505o(27535);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.m2504i(27536);
            Object obj = this.ngC.get(i);
            AppMethodBeat.m2505o(27536);
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
            AppMethodBeat.m2504i(27537);
            String str = (String) getItem(i);
            if (view == null) {
                view = ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(2130969081, viewGroup, false);
                C23262a c23262a = new C23262a(this, (byte) 0);
                c23262a.gsf = (TextView) view.findViewById(2131820678);
                view.setTag(c23262a);
                obj = c23262a;
            } else {
                obj = view.getTag();
            }
            ((C23262a) obj).gsf.setText(str);
            AppMethodBeat.m2505o(27537);
            return view;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.ProfileMobilePhoneView$1 */
    class C232631 implements OnClickListener {
        C232631() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(27532);
            ProfileMobilePhoneView.m35745a(ProfileMobilePhoneView.this, ((TextView) view).getText().toString());
            AppMethodBeat.m2505o(27532);
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
        return 2130970408;
    }

    public final void init() {
        AppMethodBeat.m2504i(27538);
        this.iDT = (TextView) findViewById(2131826656);
        this.vix = (LinearLayout) findViewById(2131826657);
        for (int i = 0; i < 5; i++) {
            this.vix.getChildAt(i).setOnClickListener(new C232631());
        }
        AppMethodBeat.m2505o(27538);
    }

    @Deprecated
    /* renamed from: T */
    public final boolean mo27223T(C7616ad c7616ad) {
        return false;
    }

    /* renamed from: hG */
    public final void mo38944hG(String str, String str2) {
        AppMethodBeat.m2504i(27539);
        C4990ab.m7417i("MicroMsg.ProfileMobilePhoneView", "phoneNumberByMD5:%s phoneNumberList:%s", str, str2);
        this.vim = str;
        this.vin = str2;
        cby();
        AppMethodBeat.m2505o(27539);
    }

    public final boolean cby() {
        AppMethodBeat.m2504i(27540);
        if (this.iDT != null) {
            LayoutParams layoutParams = this.iDT.getLayoutParams();
            layoutParams.width = C1338a.m2856al(getContext(), C25738R.dimen.f9862i8);
            this.iDT.setLayoutParams(layoutParams);
        }
        if (this.vix == null) {
            AppMethodBeat.m2505o(27540);
        } else {
            int i;
            int i2;
            View childAt;
            int i3;
            if (C5046bo.isNullOrNil(this.vim) || !C5046bo.ant(this.vim).booleanValue()) {
                if (!(this.vim == null || C5046bo.ant(this.vim).booleanValue())) {
                    C4990ab.m7413e("MicroMsg.ProfileMobilePhoneView", "mobile format is error----%s", this.vim);
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
            if (!C5046bo.isNullOrNil(this.vin)) {
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
            if (i != 1 && C5046bo.isNullOrNil(this.vin)) {
                setVisibility(8);
            }
            AppMethodBeat.m2505o(27540);
        }
        return false;
    }

    /* renamed from: a */
    static /* synthetic */ void m35745a(ProfileMobilePhoneView profileMobilePhoneView, final String str) {
        AppMethodBeat.m2504i(27541);
        final C30394k c30394k = new C30394k(profileMobilePhoneView.mContext);
        c30394k.khG = new C23261a(profileMobilePhoneView.mContext, C5046bo.m7508P(!profileMobilePhoneView.viy ? new String[]{profileMobilePhoneView.mContext.getResources().getString(C25738R.string.ang)} : new String[]{profileMobilePhoneView.mContext.getResources().getString(C25738R.string.ang), profileMobilePhoneView.mContext.getResources().getString(C25738R.string.anh)}));
        c30394k.vtI = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.m2504i(27533);
                if (c30394k != null) {
                    c30394k.dismiss();
                }
                Intent intent;
                if (i == 0) {
                    C7060h c7060h;
                    Integer[] numArr;
                    Object[] objArr;
                    int i2;
                    Integer[] numArr2;
                    Integer[] numArr3;
                    if (C5046bo.isNullOrNil(ProfileMobilePhoneView.this.vim)) {
                        c7060h = C7060h.pYm;
                        numArr3 = new Object[1];
                        numArr = numArr3;
                        objArr = numArr3;
                    } else {
                        c7060h = C7060h.pYm;
                        numArr3 = new Object[1];
                        Integer[] numArr4;
                        if (ProfileMobilePhoneView.this.vim.equals(str.trim())) {
                            i2 = 1;
                            numArr2 = numArr3;
                            numArr4 = numArr3;
                            numArr2[0] = Integer.valueOf(i2);
                            c7060h.mo8381e(12043, objArr);
                            intent = new Intent("android.intent.action.DIAL");
                            intent.setFlags(268435456);
                            intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
                            ProfileMobilePhoneView.this.getContext().startActivity(intent);
                            AppMethodBeat.m2505o(27533);
                            return;
                        }
                        numArr = numArr3;
                        numArr4 = numArr3;
                    }
                    i2 = 0;
                    numArr2 = numArr;
                    numArr2[0] = Integer.valueOf(i2);
                    c7060h.mo8381e(12043, objArr);
                    intent = new Intent("android.intent.action.DIAL");
                    intent.setFlags(268435456);
                    intent.setData(Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(str).toString()));
                    try {
                        ProfileMobilePhoneView.this.getContext().startActivity(intent);
                        AppMethodBeat.m2505o(27533);
                        return;
                    } catch (ActivityNotFoundException e) {
                        C4990ab.printErrStackTrace("MicroMsg.ProfileMobilePhoneView", e, "Activity not found!", new Object[0]);
                        AppMethodBeat.m2505o(27533);
                        return;
                    }
                }
                if (1 == i) {
                    C7060h.pYm.mo8381e(12059, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    intent = new Intent();
                    intent.putExtra("IPCallTalkUI_phoneNumber", str);
                    C25985d.m41467b(ProfileMobilePhoneView.this.mContext, "ipcall", ".ui.IPCallDialUI", intent);
                }
                AppMethodBeat.m2505o(27533);
            }
        };
        c30394k.setCancelable(true);
        c30394k.show();
        AppMethodBeat.m2505o(27541);
    }
}
