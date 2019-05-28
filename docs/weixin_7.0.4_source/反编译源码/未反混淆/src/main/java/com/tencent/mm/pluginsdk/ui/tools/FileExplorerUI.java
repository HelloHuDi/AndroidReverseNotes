package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.h;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

public class FileExplorerUI extends MMActivity {
    private int vtO = 0;
    private ListView vtP;
    private a vtQ;
    private TextView vtR;
    private TextView vtS;
    private View vtT;
    private View vtU;
    private String vtV;
    private String vtW;
    private File vtX;
    private File vtY;

    class a extends BaseAdapter {
        String fUJ;
        private File vuc;
        private File vud;
        private File[] vue;

        private a() {
        }

        /* synthetic */ a(FileExplorerUI fileExplorerUI, byte b) {
            this();
        }

        public final void g(File file, File file2) {
            AppMethodBeat.i(105847);
            this.vuc = file;
            if (file2.getAbsolutePath().equalsIgnoreCase(this.fUJ)) {
                this.vuc = null;
            }
            this.vud = file2;
            if (this.vud.canRead() && this.vud.isDirectory()) {
                this.vue = this.vud.listFiles(new FileFilter() {
                    public final boolean accept(File file) {
                        AppMethodBeat.i(105844);
                        if (file.isHidden()) {
                            AppMethodBeat.o(105844);
                            return false;
                        }
                        AppMethodBeat.o(105844);
                        return true;
                    }
                });
                if (this.vue == null) {
                    this.vue = new File[0];
                }
                if (this.vue.length > 0) {
                    a(this.vue);
                    AppMethodBeat.o(105847);
                    return;
                }
            }
            this.vue = new File[0];
            AppMethodBeat.o(105847);
        }

        public final int getCount() {
            int i = 0;
            if (this.vue == null) {
                return 0;
            }
            int length = this.vue.length;
            if (this.vuc != null) {
                i = 1;
            }
            return i + length;
        }

        public final Object getItem(int i) {
            AppMethodBeat.i(105848);
            if (this.vuc == null || i != 0) {
                ab.d("FileExplorer", "pos:" + i + ", subFile length:" + this.vue.length);
                File[] fileArr = this.vue;
                if (this.vuc != null) {
                    i--;
                }
                Object obj = fileArr[i];
                AppMethodBeat.o(105848);
                return obj;
            }
            File file = this.vuc;
            AppMethodBeat.o(105848);
            return file;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            AppMethodBeat.i(105849);
            if (view == null) {
                view = View.inflate(FileExplorerUI.this, R.layout.ab4, null);
                c cVar = new c(FileExplorerUI.this, (byte) 0);
                cVar.iqT = (ImageView) view.findViewById(R.id.d19);
                cVar.gxi = (TextView) view.findViewById(R.id.bpq);
                cVar.vuh = (TextView) view.findViewById(R.id.d1k);
                view.setTag(cVar);
            }
            c cVar2 = (c) view.getTag();
            File file = (File) getItem(i);
            if (file == this.vuc) {
                cVar2.gxi.setText(file.getName());
                cVar2.iqT.setImageResource(R.drawable.alp);
                cVar2.vuh.setVisibility(0);
            } else {
                cVar2.iqT.setImageResource(FileExplorerUI.X(file));
                cVar2.gxi.setText(file.getName());
                cVar2.vuh.setText(DateFormat.format("yyyy-MM-dd hh:mm:ss", file.lastModified()).toString() + (file.isDirectory() ? "" : "  " + bo.ga(file.length())));
            }
            AppMethodBeat.o(105849);
            return view;
        }

        private void a(File[] fileArr) {
            byte b = (byte) 0;
            AppMethodBeat.i(105850);
            if (fileArr == null || fileArr.length == 0) {
                AppMethodBeat.o(105850);
                return;
            }
            int i;
            ArrayList arrayList = new ArrayList();
            ArrayList<b> arrayList2 = new ArrayList();
            for (File file : fileArr) {
                b bVar = new b(FileExplorerUI.this, (byte) 0);
                bVar.file = file;
                bVar.vug = g.vo(file.getName()).toUpperCase();
                if (file.isDirectory()) {
                    arrayList.add(bVar);
                } else {
                    arrayList2.add(bVar);
                }
            }
            Collections.sort(arrayList, new Comparator<b>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    AppMethodBeat.i(105845);
                    int compareTo = ((b) obj).vug.compareTo(((b) obj2).vug);
                    AppMethodBeat.o(105845);
                    return compareTo;
                }
            });
            Collections.sort(arrayList2, new Comparator<b>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    AppMethodBeat.i(105846);
                    int compareTo = ((b) obj).vug.compareTo(((b) obj2).vug);
                    AppMethodBeat.o(105846);
                    return compareTo;
                }
            });
            Iterator it = arrayList.iterator();
            while (true) {
                i = b;
                if (!it.hasNext()) {
                    break;
                }
                fileArr[i] = ((b) it.next()).file;
                b = i + 1;
            }
            for (b bVar2 : arrayList2) {
                fileArr[i] = bVar2.file;
                i++;
            }
            AppMethodBeat.o(105850);
        }
    }

    class b {
        File file;
        String vug;

        private b() {
        }

        /* synthetic */ b(FileExplorerUI fileExplorerUI, byte b) {
            this();
        }
    }

    class c {
        TextView gxi;
        ImageView iqT;
        TextView vuh;

        private c() {
        }

        /* synthetic */ c(FileExplorerUI fileExplorerUI, byte b) {
            this();
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    static /* synthetic */ void dlo() {
    }

    public final int getLayoutId() {
        return R.layout.ab3;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(105851);
        super.onCreate(bundle);
        String stringExtra = getIntent().getStringExtra("key_title");
        if (bo.isNullOrNil(stringExtra)) {
            setMMTitle((int) R.string.ddr);
        } else {
            setMMTitle(stringExtra);
        }
        initView();
        AppMethodBeat.o(105851);
    }

    public void onResume() {
        AppMethodBeat.i(105852);
        super.onResume();
        AppMethodBeat.o(105852);
    }

    public void onPause() {
        AppMethodBeat.i(105853);
        super.onPause();
        AppMethodBeat.o(105853);
    }

    public void onDestroy() {
        AppMethodBeat.i(105854);
        super.onDestroy();
        AppMethodBeat.o(105854);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(105855);
        if (i != 4 || this.vtQ.vuc == null) {
            if (this.vtY != null) {
                com.tencent.mm.kernel.g.RP().Ry().set(131074, this.vtY.getAbsolutePath());
            }
            if (this.vtX != null) {
                com.tencent.mm.kernel.g.RP().Ry().set(131073, this.vtX.getAbsolutePath());
            }
            boolean onKeyDown = super.onKeyDown(i, keyEvent);
            AppMethodBeat.o(105855);
            return onKeyDown;
        }
        if (1 == this.vtO) {
            this.vtY = this.vtQ.vuc;
        } else if (this.vtO == 0) {
            this.vtX = this.vtQ.vuc;
        }
        this.vtQ.g(this.vtQ.vuc.getParentFile(), this.vtQ.vuc);
        this.vtQ.notifyDataSetChanged();
        this.vtP.setSelection(0);
        AppMethodBeat.o(105855);
        return true;
    }

    public final void initView() {
        boolean z;
        boolean z2 = true;
        AppMethodBeat.i(105856);
        this.vtP = (ListView) findViewById(R.id.d1j);
        this.vtR = (TextView) findViewById(R.id.d1f);
        this.vtT = findViewById(R.id.d1g);
        this.vtS = (TextView) findViewById(R.id.d1h);
        this.vtU = findViewById(R.id.d1i);
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(105840);
                if (FileExplorerUI.this.vtQ.vuc != null) {
                    if (1 == FileExplorerUI.this.vtO) {
                        FileExplorerUI.this.vtY = FileExplorerUI.this.vtQ.vuc;
                    } else if (FileExplorerUI.this.vtO == 0) {
                        FileExplorerUI.this.vtX = FileExplorerUI.this.vtQ.vuc;
                    }
                    FileExplorerUI.this.vtQ.g(FileExplorerUI.this.vtQ.vuc.getParentFile(), FileExplorerUI.this.vtQ.vuc);
                    FileExplorerUI.this.vtQ.notifyDataSetChanged();
                    FileExplorerUI.this.vtP.setSelection(0);
                    FileExplorerUI.dlo();
                    AppMethodBeat.o(105840);
                } else {
                    com.tencent.mm.kernel.g.RP().Ry().set(131074, FileExplorerUI.this.vtY.getAbsolutePath());
                    com.tencent.mm.kernel.g.RP().Ry().set(131073, FileExplorerUI.this.vtX.getAbsolutePath());
                    FileExplorerUI.this.finish();
                    AppMethodBeat.o(105840);
                }
                return true;
            }
        });
        this.vtV = getString(R.string.ddp);
        this.vtW = getString(R.string.ddq);
        final File dlm = dlm();
        final File dln = dln();
        this.vtX = V(dlm);
        this.vtY = W(dln);
        this.vtQ = new a(this, (byte) 0);
        if (dln != null) {
            Lr(1);
            this.vtQ.fUJ = dln.getPath();
            this.vtQ.g(this.vtY.getParentFile(), this.vtY);
        } else if (dlm != null) {
            Lr(0);
            this.vtQ.fUJ = dlm.getPath();
            this.vtQ.g(this.vtX.getParentFile(), this.vtX);
        } else {
            ab.d("MicroMsg.FileExplorerUI", "left and right tag disabled in the same time.");
            AppMethodBeat.o(105856);
            return;
        }
        TextView textView = this.vtR;
        if (dlm != null) {
            z = true;
        } else {
            z = false;
        }
        textView.setEnabled(z);
        TextView textView2 = this.vtS;
        if (dln == null) {
            z2 = false;
        }
        textView2.setEnabled(z2);
        this.vtP.setAdapter(this.vtQ);
        this.vtQ.notifyDataSetChanged();
        this.vtP.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(105841);
                File file = (File) FileExplorerUI.this.vtQ.getItem(i);
                if (1 == FileExplorerUI.this.vtO) {
                    if (file.isFile()) {
                        com.tencent.mm.kernel.g.RP().Ry().set(131074, FileExplorerUI.this.vtQ.vud.getAbsolutePath());
                        com.tencent.mm.kernel.g.RP().Ry().set(131073, FileExplorerUI.this.vtX.getAbsolutePath());
                    } else {
                        FileExplorerUI.this.vtY = file;
                    }
                } else if (FileExplorerUI.this.vtO == 0) {
                    if (file.isFile()) {
                        com.tencent.mm.kernel.g.RP().Ry().set(131073, FileExplorerUI.this.vtQ.vud.getAbsolutePath());
                        com.tencent.mm.kernel.g.RP().Ry().set(131074, FileExplorerUI.this.vtY.getAbsolutePath());
                    } else {
                        FileExplorerUI.this.vtX = file;
                    }
                }
                if (file == FileExplorerUI.this.vtQ.vuc) {
                    FileExplorerUI.this.vtQ.g(FileExplorerUI.this.vtQ.vuc.getParentFile(), FileExplorerUI.this.vtQ.vuc);
                } else if (file.isDirectory()) {
                    FileExplorerUI.this.vtQ.g(FileExplorerUI.this.vtQ.vud, file);
                } else if (file.isFile()) {
                    FileExplorerUI.this.setResult(-1, new Intent().putExtra("choosed_file_path", file.getAbsolutePath()));
                    FileExplorerUI.this.finish();
                }
                FileExplorerUI.dlo();
                FileExplorerUI.this.vtQ.notifyDataSetChanged();
                FileExplorerUI.this.vtP.setSelection(0);
                AppMethodBeat.o(105841);
            }
        });
        this.vtR.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(105842);
                FileExplorerUI.a(FileExplorerUI.this, 0);
                FileExplorerUI.this.vtQ.fUJ = dlm.getPath();
                FileExplorerUI.this.vtQ.g(FileExplorerUI.this.vtX.getParentFile(), FileExplorerUI.this.vtX);
                FileExplorerUI.this.vtQ.notifyDataSetInvalidated();
                FileExplorerUI.this.vtQ.notifyDataSetChanged();
                FileExplorerUI.this.vtP.setSelection(0);
                AppMethodBeat.o(105842);
            }
        });
        this.vtS.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                AppMethodBeat.i(105843);
                FileExplorerUI.a(FileExplorerUI.this, 1);
                FileExplorerUI.this.vtQ.fUJ = dln.getPath();
                FileExplorerUI.this.vtQ.g(FileExplorerUI.this.vtY.getParentFile(), FileExplorerUI.this.vtY);
                FileExplorerUI.this.vtQ.notifyDataSetInvalidated();
                FileExplorerUI.this.vtQ.notifyDataSetChanged();
                FileExplorerUI.this.vtP.setSelection(0);
                AppMethodBeat.o(105843);
            }
        });
        AppMethodBeat.o(105856);
    }

    private void Lr(int i) {
        AppMethodBeat.i(105857);
        if (1 == i) {
            this.vtO = 1;
            this.vtS.setTextColor(getResources().getColor(R.color.r8));
            this.vtR.setTextColor(getResources().getColor(R.color.w4));
            this.vtT.setVisibility(4);
            this.vtU.setVisibility(0);
            AppMethodBeat.o(105857);
            return;
        }
        this.vtO = 0;
        this.vtR.setTextColor(getResources().getColor(R.color.r8));
        this.vtS.setTextColor(getResources().getColor(R.color.w4));
        this.vtT.setVisibility(0);
        this.vtU.setVisibility(4);
        AppMethodBeat.o(105857);
    }

    private File dlm() {
        AppMethodBeat.i(105858);
        File rootDirectory = h.getRootDirectory();
        if (rootDirectory.canRead()) {
            AppMethodBeat.o(105858);
            return rootDirectory;
        }
        rootDirectory = h.getDataDirectory();
        if (rootDirectory.canRead()) {
            this.vtV = rootDirectory.getName();
            AppMethodBeat.o(105858);
            return rootDirectory;
        }
        AppMethodBeat.o(105858);
        return null;
    }

    private File dln() {
        AppMethodBeat.i(105859);
        File externalStorageDirectory;
        if (com.tencent.mm.kernel.g.RP().isSDCardAvailable()) {
            externalStorageDirectory = h.getExternalStorageDirectory();
            AppMethodBeat.o(105859);
            return externalStorageDirectory;
        }
        externalStorageDirectory = h.getDownloadCacheDirectory();
        if (externalStorageDirectory.canRead()) {
            this.vtW = externalStorageDirectory.getName();
            AppMethodBeat.o(105859);
            return externalStorageDirectory;
        }
        AppMethodBeat.o(105859);
        return null;
    }

    private static File V(File file) {
        AppMethodBeat.i(105860);
        String str = (String) com.tencent.mm.kernel.g.RP().Ry().get(131073, file == null ? null : file.getAbsolutePath());
        if (!(str == null || file == null || file.getAbsolutePath().equals(str))) {
            File file2 = new File(str);
            if (file2.exists()) {
                AppMethodBeat.o(105860);
                return file2;
            }
        }
        AppMethodBeat.o(105860);
        return file;
    }

    private static File W(File file) {
        AppMethodBeat.i(105861);
        String str = (String) com.tencent.mm.kernel.g.RP().Ry().get(131074, file == null ? null : file.getAbsolutePath());
        if (!(str == null || file == null || file.getAbsolutePath().equals(str))) {
            File file2 = new File(str);
            if (file2.exists()) {
                AppMethodBeat.o(105861);
                return file2;
            }
        }
        AppMethodBeat.o(105861);
        return file;
    }

    public static int ajW(String str) {
        Object obj;
        Object obj2 = null;
        AppMethodBeat.i(105862);
        String toLowerCase = str.toLowerCase();
        String toLowerCase2 = bo.nullAsNil(toLowerCase).toLowerCase();
        if (toLowerCase2.endsWith(".doc") || toLowerCase2.endsWith(".docx") || toLowerCase2.endsWith("wps")) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            AppMethodBeat.o(105862);
            return R.raw.app_attach_file_icon_word;
        } else if (ajX(toLowerCase)) {
            AppMethodBeat.o(105862);
            return R.drawable.alr;
        } else {
            toLowerCase2 = bo.nullAsNil(toLowerCase).toLowerCase();
            if (toLowerCase2.endsWith(".rar") || toLowerCase2.endsWith(".zip") || toLowerCase2.endsWith(".7z") || toLowerCase2.endsWith("tar") || toLowerCase2.endsWith(".iso")) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                AppMethodBeat.o(105862);
                return R.raw.app_attach_file_icon_rar;
            }
            toLowerCase2 = bo.nullAsNil(toLowerCase).toLowerCase();
            if (toLowerCase2.endsWith(".txt") || toLowerCase2.endsWith(".rtf")) {
                obj = 1;
            } else {
                obj = null;
            }
            if (obj != null) {
                AppMethodBeat.o(105862);
                return R.raw.app_attach_file_icon_txt;
            } else if (bo.nullAsNil(toLowerCase).toLowerCase().endsWith(".pdf")) {
                AppMethodBeat.o(105862);
                return R.raw.app_attach_file_icon_pdf;
            } else {
                toLowerCase2 = bo.nullAsNil(toLowerCase).toLowerCase();
                if (toLowerCase2.endsWith(".ppt") || toLowerCase2.endsWith(".pptx")) {
                    obj = 1;
                } else {
                    obj = null;
                }
                if (obj != null) {
                    AppMethodBeat.o(105862);
                    return R.raw.app_attach_file_icon_ppt;
                }
                toLowerCase2 = bo.nullAsNil(toLowerCase).toLowerCase();
                if (toLowerCase2.endsWith(".xls") || toLowerCase2.endsWith(".xlsx")) {
                    obj2 = 1;
                }
                if (obj2 != null) {
                    AppMethodBeat.o(105862);
                    return R.raw.app_attach_file_icon_excel;
                }
                AppMethodBeat.o(105862);
                return R.raw.app_attach_file_icon_unknow;
            }
        }
    }

    public static boolean ajX(String str) {
        AppMethodBeat.i(105863);
        String toLowerCase = bo.nullAsNil(str).toLowerCase();
        if (toLowerCase.endsWith(".bmp") || toLowerCase.endsWith(".png") || toLowerCase.endsWith(FileUtils.PIC_POSTFIX_JPEG) || toLowerCase.endsWith(".jpeg") || toLowerCase.endsWith(".gif")) {
            AppMethodBeat.o(105863);
            return true;
        }
        AppMethodBeat.o(105863);
        return false;
    }

    public static boolean ajY(String str) {
        AppMethodBeat.i(105864);
        String toLowerCase = bo.nullAsNil(str).toLowerCase();
        if (toLowerCase.endsWith(".mp3") || toLowerCase.endsWith(".wma") || toLowerCase.endsWith(VideoMaterialUtil.MP4_SUFFIX) || toLowerCase.endsWith(".rm")) {
            AppMethodBeat.o(105864);
            return true;
        }
        AppMethodBeat.o(105864);
        return false;
    }

    static /* synthetic */ int X(File file) {
        AppMethodBeat.i(105866);
        if (file.isDirectory()) {
            AppMethodBeat.o(105866);
            return R.drawable.alq;
        }
        int ajW = ajW(file.getName());
        AppMethodBeat.o(105866);
        return ajW;
    }
}
