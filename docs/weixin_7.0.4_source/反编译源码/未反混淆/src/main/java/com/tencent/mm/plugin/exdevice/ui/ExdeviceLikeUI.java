package com.tencent.mm.plugin.exdevice.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.bp.d;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.exdevice.f.b.a.e;
import com.tencent.mm.plugin.exdevice.model.ad;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.e.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import java.util.ArrayList;
import java.util.Map;
import junit.framework.Assert;

public class ExdeviceLikeUI extends MMActivity {
    private ArrayList<e> lAT;
    private boolean lAU;
    private ListView lAV;
    private a lAW;
    private final int lAX = 30;
    private String mAppName;

    class a extends BaseAdapter {

        class a {
            ImageView eks;
            TextView gJE;
            NoMeasuredTextView lAZ;
            TextView timeTv;

            a() {
            }
        }

        a() {
        }

        public final int getCount() {
            AppMethodBeat.i(19972);
            if (ExdeviceLikeUI.this.lAT == null) {
                AppMethodBeat.o(19972);
                return 0;
            }
            int size = ExdeviceLikeUI.this.lAT.size();
            AppMethodBeat.o(19972);
            return size;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(19973);
            Object obj = ExdeviceLikeUI.this.lAT.get(i);
            AppMethodBeat.o(19973);
            return obj;
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            a aVar;
            AppMethodBeat.i(19974);
            e eVar = (e) ExdeviceLikeUI.this.lAT.get(i);
            if (view == null) {
                if (ExdeviceLikeUI.this.lAU) {
                    inflate = LayoutInflater.from(ExdeviceLikeUI.this).inflate(R.layout.w4, viewGroup, false);
                } else {
                    inflate = LayoutInflater.from(ExdeviceLikeUI.this).inflate(R.layout.w3, viewGroup, false);
                }
                a aVar2 = new a();
                aVar2.eks = (ImageView) inflate.findViewById(R.id.bj6);
                aVar2.lAZ = (NoMeasuredTextView) inflate.findViewById(R.id.bj8);
                aVar2.gJE = (TextView) inflate.findViewById(R.id.bj9);
                aVar2.timeTv = (TextView) inflate.findViewById(R.id.bj7);
                aVar2.lAZ.setTextSize(0, ExdeviceLikeUI.this.getResources().getDimension(R.dimen.m5));
                aVar2.lAZ.setTextColor(ExdeviceLikeUI.this.getResources().getColor(R.color.h4));
                aVar2.lAZ.setSingleLine(true);
                aVar2.lAZ.setShouldEllipsize(true);
                inflate.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
                inflate = view;
            }
            b.s(aVar.eks, eVar.field_username);
            aVar.lAZ.setText(j.b(ExdeviceLikeUI.this, s.mJ(eVar.field_username), aVar.lAZ.getTextSize()));
            if (!bo.isNullOrNil(eVar.field_liketips) && aVar.gJE != null) {
                aVar.gJE.setVisibility(0);
                aVar.gJE.setText(eVar.field_liketips);
            } else if (aVar.gJE != null) {
                aVar.gJE.setVisibility(8);
            }
            if (((int) ((((System.currentTimeMillis() / 1000) - ((long) eVar.field_timestamp)) / 60) + 1)) <= 30) {
                aVar.timeTv.setText(ExdeviceLikeUI.this.getString(R.string.bgo, new Object[]{Integer.valueOf(r3)}));
            } else {
                aVar.timeTv.setText(h.c(ExdeviceLikeUI.this, ((long) eVar.field_timestamp) * 1000, true));
            }
            AppMethodBeat.o(19974);
            return inflate;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(19975);
        super.onCreate(bundle);
        this.mAppName = getIntent().getStringExtra("app_username");
        String stringExtra = getIntent().getStringExtra("key_rank_info");
        String stringExtra2 = getIntent().getStringExtra("key_rank_semi");
        this.lAU = getIntent().getBooleanExtra("key_is_like_read_only", false);
        if (bo.isNullOrNil(stringExtra)) {
            boolean z;
            stringExtra2 = getIntent().getStringExtra("rank_id");
            if (bo.isNullOrNil(stringExtra2)) {
                z = false;
            } else {
                z = true;
            }
            Assert.assertTrue(z);
            this.lAT = ad.bpb().Ks(stringExtra2);
        } else {
            ArrayList arrayList;
            String str = this.mAppName;
            ab.d("MicroMsg.ExdeviceMsgXmlParser", stringExtra);
            if (bo.isNullOrNil(stringExtra)) {
                ab.e("MicroMsg.ExdeviceMsgXmlParser", "like info is null or nil");
            } else {
                com.tencent.mm.af.j.b X = com.tencent.mm.af.j.b.X(stringExtra, stringExtra2);
                if (X != null) {
                    Map map = X.fgm;
                    ArrayList arrayList2 = new ArrayList();
                    if (!(map == null || map.isEmpty())) {
                        int i = 0;
                        while (true) {
                            stringExtra = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".username");
                            if (bo.isNullOrNil(stringExtra)) {
                                break;
                            }
                            stringExtra2 = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".rankid");
                            String str2 = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".liketip");
                            String str3 = (String) map.get(".msg.appmsg.hardwareinfo.likeuserlist.userinfo" + (i == 0 ? "" : Integer.valueOf(i)) + ".timestamp");
                            e eVar = new e();
                            eVar.field_appusername = str;
                            eVar.field_rankID = stringExtra2;
                            eVar.field_username = stringExtra;
                            eVar.field_timestamp = bo.getInt(str3, 0);
                            eVar.field_liketips = str2;
                            arrayList2.add(eVar);
                            i++;
                        }
                        ab.i("MicroMsg.ExdeviceMsgXmlParser", "should break now : %d", Integer.valueOf(i));
                        arrayList = arrayList2;
                        this.lAT = arrayList;
                    }
                }
            }
            arrayList = null;
            this.lAT = arrayList;
        }
        this.lAV = (ListView) findViewById(R.id.bj_);
        this.lAV.setEmptyView(findViewById(R.id.a5j));
        this.lAW = new a();
        this.lAV.setAdapter(this.lAW);
        if (!this.lAU) {
            this.lAV.setOnItemClickListener(new OnItemClickListener() {
                public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                    AppMethodBeat.i(19970);
                    e eVar = (e) ExdeviceLikeUI.this.lAW.getItem(i);
                    Intent intent = new Intent(ExdeviceLikeUI.this, ExdeviceRankInfoUI.class);
                    intent.putExtra("app_username", eVar.field_appusername);
                    intent.putExtra("rank_id", eVar.field_rankID);
                    intent.putExtra("device_type", 1);
                    ExdeviceLikeUI.this.startActivity(intent);
                    ExdeviceLikeUI.this.finish();
                    AppMethodBeat.o(19970);
                }
            });
        }
        this.lAV.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(19971);
                e eVar = (e) ExdeviceLikeUI.this.lAT.get(i);
                Intent intent = new Intent();
                intent.putExtra("rank_id", eVar.field_rankID);
                intent.putExtra("device_type", 1);
                intent.putExtra("locate_to_username", eVar.field_username);
                intent.putExtra("app_username", s.mJ("gh_43f2581f6fd6"));
                d.b(ExdeviceLikeUI.this, "exdevice", ".ui.ExdeviceRankInfoUI", intent);
                AppMethodBeat.o(19971);
            }
        });
        setMMTitle((int) R.string.bgp);
        if (!this.lAU) {
            addTextOptionMenu(0, getString(R.string.bgn), new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(19968);
                    Intent intent = new Intent(ExdeviceLikeUI.this, ExdeviceRankInfoUI.class);
                    intent.putExtra("app_username", ExdeviceLikeUI.this.mAppName);
                    intent.putExtra("rank_id", "#");
                    intent.putExtra("key_is_latest", true);
                    intent.putExtra("device_type", 1);
                    ExdeviceLikeUI.this.startActivity(intent);
                    ExdeviceLikeUI.this.finish();
                    AppMethodBeat.o(19968);
                    return false;
                }
            });
        }
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(19969);
                ExdeviceLikeUI.this.finish();
                AppMethodBeat.o(19969);
                return false;
            }
        });
        AppMethodBeat.o(19975);
    }

    public final int getLayoutId() {
        return R.layout.w5;
    }
}
