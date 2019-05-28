package com.tencent.mm.plugin.nearlife.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.ba.k;
import com.tencent.mm.g.a.mn;
import com.tencent.mm.model.aw;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ac;
import com.tencent.mm.ui.MMActivity;
import com.tencent.ttpic.baseutils.IOUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SelectPoiCategoryUI extends MMActivity {
    static final String oSN = (ac.eSj + "poi_categories");
    private ListView mListView;
    private OnMenuItemClickListener oSI = new OnMenuItemClickListener() {
        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.i(22999);
            SelectPoiCategoryUI.this.setResult(0, null);
            SelectPoiCategoryUI.this.finish();
            AppMethodBeat.o(22999);
            return true;
        }
    };
    private a oSO;
    private ArrayAdapter<String> oSP;
    private List<String> oSQ;
    private OnItemClickListener oSR = new OnItemClickListener() {
        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.i(22998);
            ab.d("MicroMsg.SelectPoiCategoryUI", "item click on pos:%d, len:%d", Integer.valueOf(i), Integer.valueOf(SelectPoiCategoryUI.this.oSQ.size()));
            Intent intent = new Intent();
            intent.putExtra("poi_category", (String) SelectPoiCategoryUI.this.oSQ.get(i));
            SelectPoiCategoryUI.this.setResult(-1, intent);
            SelectPoiCategoryUI.this.finish();
            AppMethodBeat.o(22998);
        }
    };

    class a extends c<mn> {
        SelectPoiCategoryUI oST;

        public a() {
            super(0);
            AppMethodBeat.i(23000);
            this.xxI = mn.class.getName().hashCode();
            AppMethodBeat.o(23000);
        }

        private boolean a(mn mnVar) {
            AppMethodBeat.i(23001);
            if (mnVar instanceof mn) {
                SelectPoiCategoryUI selectPoiCategoryUI = this.oST;
                byte[] bArr = mnVar.cIq.content;
                File file = new File(SelectPoiCategoryUI.oSN);
                if (!file.exists()) {
                    file.mkdir();
                }
                try {
                    String str = SelectPoiCategoryUI.oSN + "/lastest_poi_categories.dat";
                    File file2 = new File(str);
                    if (!file2.exists()) {
                        file2.createNewFile();
                    }
                    e.b(str, bArr, bArr.length);
                } catch (Exception e) {
                    ab.e("MicroMsg.SelectPoiCategoryUI", "write file failed: " + e.getMessage());
                }
                selectPoiCategoryUI.bc(bArr);
                selectPoiCategoryUI.bVr();
            }
            AppMethodBeat.o(23001);
            return false;
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public SelectPoiCategoryUI() {
        AppMethodBeat.i(23003);
        AppMethodBeat.o(23003);
    }

    static {
        AppMethodBeat.i(23011);
        AppMethodBeat.o(23011);
    }

    public final int getLayoutId() {
        return R.layout.aqv;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(23004);
        super.onCreate(bundle);
        this.oSQ = new ArrayList();
        initView();
        this.oSO = new a();
        com.tencent.mm.sdk.b.a.xxA.c(this.oSO);
        this.oSO.oST = this;
        aw.Rg().a(new k(17), 0);
        AppMethodBeat.o(23004);
    }

    public final void initView() {
        AppMethodBeat.i(23005);
        setMMTitle((int) R.string.d7f);
        setBackBtn(this.oSI);
        this.oSP = new ArrayAdapter(this, R.layout.aki);
        this.mListView = (ListView) findViewById(R.id.e8e);
        this.mListView.setAdapter(this.oSP);
        this.mListView.setOnItemClickListener(this.oSR);
        if (!TF(oSN + "/lastest_poi_categories.dat")) {
            try {
                D(getAssets().open("default_poi_categories.dat"));
            } catch (IOException e) {
                ab.d("MicroMsg.SelectPoiCategoryUI", "open file from assets failed: " + e.getMessage());
            }
        }
        bVr();
        AppMethodBeat.o(23005);
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0048 A:{SYNTHETIC, Splitter:B:15:0x0048} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0096 A:{SYNTHETIC, Splitter:B:28:0x0096} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean D(InputStream inputStream) {
        IOException e;
        Throwable th;
        AppMethodBeat.i(23006);
        if (inputStream == null) {
            AppMethodBeat.o(23006);
            return false;
        }
        this.oSQ.clear();
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        this.oSQ.add(readLine);
                    } else {
                        try {
                            break;
                        } catch (Exception e2) {
                            ab.d("MicroMsg.SelectPoiCategoryUI", "close file failed: " + e2.getMessage());
                        }
                    }
                } catch (IOException e3) {
                    e = e3;
                    try {
                        ab.d("MicroMsg.SelectPoiCategoryUI", "read file failed: " + e.getMessage());
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e22) {
                                ab.d("MicroMsg.SelectPoiCategoryUI", "close file failed: " + e22.getMessage());
                            }
                        }
                        inputStream.close();
                        AppMethodBeat.o(23006);
                        return true;
                    } catch (Throwable th2) {
                        th = th2;
                        if (bufferedReader != null) {
                        }
                        inputStream.close();
                        AppMethodBeat.o(23006);
                        throw th;
                    }
                }
            }
            bufferedReader.close();
            inputStream.close();
        } catch (IOException e4) {
            e = e4;
            bufferedReader = null;
            ab.d("MicroMsg.SelectPoiCategoryUI", "read file failed: " + e.getMessage());
            if (bufferedReader != null) {
            }
            inputStream.close();
            AppMethodBeat.o(23006);
            return true;
        } catch (Throwable th3) {
            th = th3;
            bufferedReader = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (Exception e5) {
                    ab.d("MicroMsg.SelectPoiCategoryUI", "close file failed: " + e5.getMessage());
                    AppMethodBeat.o(23006);
                    throw th;
                }
            }
            inputStream.close();
            AppMethodBeat.o(23006);
            throw th;
        }
        AppMethodBeat.o(23006);
        return true;
    }

    private boolean TF(String str) {
        boolean z = false;
        AppMethodBeat.i(23007);
        if (bo.isNullOrNil(str)) {
            AppMethodBeat.o(23007);
        } else {
            File file = new File(str);
            if (file.exists()) {
                try {
                    z = D(new FileInputStream(file));
                    AppMethodBeat.o(23007);
                } catch (FileNotFoundException e) {
                    ab.d("MicroMsg.SelectPoiCategoryUI", "update poi categories failed, path:%s, msg:%s", str, e.getMessage());
                    AppMethodBeat.o(23007);
                }
            } else {
                AppMethodBeat.o(23007);
            }
        }
        return z;
    }

    public void onDestroy() {
        AppMethodBeat.i(23008);
        super.onDestroy();
        com.tencent.mm.sdk.b.a.xxA.d(this.oSO);
        AppMethodBeat.o(23008);
    }

    /* Access modifiers changed, original: final */
    public final void bc(byte[] bArr) {
        AppMethodBeat.i(23009);
        String[] split = new String(bArr).split(IOUtils.LINE_SEPARATOR_UNIX);
        this.oSQ.clear();
        for (String trim : split) {
            this.oSQ.add(trim.trim());
        }
        AppMethodBeat.o(23009);
    }

    /* Access modifiers changed, original: final */
    public final void bVr() {
        AppMethodBeat.i(23010);
        this.oSP.clear();
        for (int i = 0; i < this.oSQ.size(); i++) {
            this.oSP.add(this.oSQ.get(i));
        }
        this.oSP.notifyDataSetChanged();
        AppMethodBeat.o(23010);
    }
}
