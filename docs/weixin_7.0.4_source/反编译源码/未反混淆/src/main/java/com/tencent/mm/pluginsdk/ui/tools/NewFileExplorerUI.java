package com.tencent.mm.pluginsdk.ui.tools;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.provider.MediaStore.Images.Media;
import android.provider.MediaStore.Images.Thumbnails;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R;
import com.tencent.mm.compatible.util.e;
import com.tencent.mm.platformtools.g;
import com.tencent.mm.pluginsdk.f.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.q.b;
import com.tencent.ttpic.baseutils.FileUtils;
import com.tencent.ttpic.util.VideoMaterialUtil;
import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(19)
public class NewFileExplorerUI extends MMActivity {
    private ListView gGW;
    private int mode = 0;
    private TextView pxy;
    private String toUserName;
    private a vuV;
    private TextView vuW;
    private FileSelectorFolderView vuX;
    private com.tencent.mm.pluginsdk.ui.applet.g.a vuY;
    private com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView.a vuZ = new com.tencent.mm.pluginsdk.ui.tools.FileSelectorFolderView.a() {
        public final void Ls(int i) {
            AppMethodBeat.i(28181);
            ab.i("MicroMsg.FileExplorerUI", "position: %d", Integer.valueOf(i));
            if (i == 0) {
                NewFileExplorerUI.this.setMMTitle((int) R.string.bsw);
                NewFileExplorerUI.this.setMMSubTitle(null);
                NewFileExplorerUI.this.vuW = (TextView) NewFileExplorerUI.this.findViewById(R.id.dhu);
                NewFileExplorerUI.this.vuW.setText(R.string.bsw);
                NewFileExplorerUI.this.vuV.c(new File(e.euQ), true);
                NewFileExplorerUI.this.vuV.a(new File(e.euQ), null);
            } else {
                NewFileExplorerUI.this.vuV.c(new File(e.eSl), false);
                NewFileExplorerUI.this.vuV.a(new File(e.eSl), null);
                NewFileExplorerUI.this.setMMTitle((int) R.string.bsx);
                NewFileExplorerUI.this.vuW.setText(R.string.bsx);
            }
            NewFileExplorerUI.this.vuV.notifyDataSetChanged();
            NewFileExplorerUI.c(NewFileExplorerUI.this);
            AppMethodBeat.o(28181);
        }
    };

    public class a extends BaseAdapter {
        private File vud;
        File[] vue = new File[0];
        private File vvb;
        private boolean vvc = false;
        private ArrayList<File> vvd = new ArrayList();

        class a {
            File file;
            long time;
            String vvf;

            private a() {
            }

            /* synthetic */ a(a aVar, byte b) {
                this();
            }
        }

        class b {
            public TextView enf;
            public TextView gnB;
            public ImageView iqT;
            public TextView pxy;
            public FrameLayout vvg;
            public CheckBox vvh;

            private b() {
            }

            /* synthetic */ b(a aVar, byte b) {
                this();
            }
        }

        public a() {
            AppMethodBeat.i(28186);
            AppMethodBeat.o(28186);
        }

        public final void c(File file, boolean z) {
            this.vvb = file;
            this.vvc = z;
        }

        public final void a(File file, List<String> list) {
            int i = 0;
            AppMethodBeat.i(28187);
            this.vud = file;
            if (this.vud != null && this.vud.canRead() && this.vud.isDirectory()) {
                this.vue = this.vud.listFiles(new FileFilter() {
                    public final boolean accept(File file) {
                        AppMethodBeat.i(28182);
                        if (file.isHidden()) {
                            AppMethodBeat.o(28182);
                            return false;
                        } else if (a.this.vvc && file.isDirectory()) {
                            AppMethodBeat.o(28182);
                            return false;
                        } else {
                            AppMethodBeat.o(28182);
                            return true;
                        }
                    }
                });
                if (this.vue == null) {
                    this.vue = new File[0];
                }
                if (this.vue.length > 0) {
                    a(this.vue);
                    AppMethodBeat.o(28187);
                    return;
                }
            } else if (list != null) {
                this.vue = new File[list.size()];
                while (true) {
                    int i2 = i;
                    if (i2 >= list.size()) {
                        break;
                    }
                    this.vue[i2] = new File((String) list.get(i2));
                    this.vvd.add(this.vue[i2]);
                    i = i2 + 1;
                }
            }
            AppMethodBeat.o(28187);
        }

        public final int cdf() {
            AppMethodBeat.i(28188);
            int i = 0;
            Iterator it = this.vvd.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    i = (int) (((File) it.next()).length() + ((long) i2));
                } else {
                    AppMethodBeat.o(28188);
                    return i2;
                }
            }
        }

        public final ArrayList<String> dlu() {
            AppMethodBeat.i(28189);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.vvd.iterator();
            while (it.hasNext()) {
                File file = (File) it.next();
                if (!(ajX(file.getName()) || aI(file.getName()))) {
                    arrayList.add(file.getPath());
                }
            }
            AppMethodBeat.o(28189);
            return arrayList;
        }

        public final ArrayList<String> dlv() {
            AppMethodBeat.i(28190);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.vvd.iterator();
            while (it.hasNext()) {
                File file = (File) it.next();
                if (ajX(file.getName())) {
                    arrayList.add(file.getPath());
                }
            }
            AppMethodBeat.o(28190);
            return arrayList;
        }

        public final ArrayList<String> dlw() {
            AppMethodBeat.i(28191);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.vvd.iterator();
            while (it.hasNext()) {
                File file = (File) it.next();
                if (aI(file.getName())) {
                    arrayList.add(file.getPath());
                }
            }
            AppMethodBeat.o(28191);
            return arrayList;
        }

        public final File dlx() {
            AppMethodBeat.i(28192);
            if (this.vud.hashCode() == this.vvb.hashCode()) {
                AppMethodBeat.o(28192);
                return null;
            }
            File parentFile = this.vud.getParentFile();
            AppMethodBeat.o(28192);
            return parentFile;
        }

        private void a(File[] fileArr) {
            byte b = (byte) 0;
            AppMethodBeat.i(28193);
            if (fileArr == null || fileArr.length == 0) {
                AppMethodBeat.o(28193);
                return;
            }
            int i;
            ArrayList arrayList = new ArrayList();
            ArrayList<a> arrayList2 = new ArrayList();
            for (File file : fileArr) {
                a aVar = new a(this, (byte) 0);
                aVar.file = file;
                aVar.time = file.lastModified();
                if (file.isDirectory()) {
                    aVar.vvf = g.vo(file.getName()).toUpperCase();
                    arrayList.add(aVar);
                } else {
                    arrayList2.add(aVar);
                }
            }
            Collections.sort(arrayList, new Comparator<a>() {
                public final /* synthetic */ int compare(Object obj, Object obj2) {
                    AppMethodBeat.i(28183);
                    int compareTo = ((a) obj).vvf.compareTo(((a) obj2).vvf);
                    AppMethodBeat.o(28183);
                    return compareTo;
                }
            });
            Collections.sort(arrayList2, new Comparator<a>() {
                public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                    a aVar = (a) obj;
                    a aVar2 = (a) obj2;
                    if (aVar.time == aVar2.time) {
                        return 0;
                    }
                    return aVar.time > aVar2.time ? -1 : 1;
                }
            });
            Iterator it = arrayList.iterator();
            while (true) {
                i = b;
                if (!it.hasNext()) {
                    break;
                }
                fileArr[i] = ((a) it.next()).file;
                b = i + 1;
            }
            for (a aVar2 : arrayList2) {
                fileArr[i] = aVar2.file;
                i++;
            }
            AppMethodBeat.o(28193);
        }

        public final int getCount() {
            return this.vue.length;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            Bitmap bitmap = null;
            AppMethodBeat.i(28194);
            if (view == null) {
                view = View.inflate(viewGroup.getContext(), R.layout.a02, null);
                b bVar = new b(this, (byte) 0);
                bVar.vvg = (FrameLayout) view.findViewById(R.id.bud);
                bVar.vvh = (CheckBox) bVar.vvg.findViewById(R.id.buf);
                bVar.iqT = (ImageView) view.findViewById(R.id.be7);
                bVar.gnB = (TextView) view.findViewById(R.id.bgm);
                bVar.pxy = (TextView) view.findViewById(R.id.ba5);
                bVar.enf = (TextView) view.findViewById(R.id.bue);
                bVar.vvg.setOnClickListener(new OnClickListener() {
                    public final void onClick(View view) {
                        AppMethodBeat.i(28184);
                        Object obj = a.this.vue[((Integer) view.getTag()).intValue()];
                        CheckBox checkBox = (CheckBox) view.findViewById(R.id.buf);
                        if (a.this.vvd.contains(obj)) {
                            a.this.vvd.remove(obj);
                            checkBox.setChecked(false);
                        } else if (a.this.vvd.size() >= 9) {
                            t.makeText(NewFileExplorerUI.this.mController.ylL, NewFileExplorerUI.this.getString(R.string.bta, new Object[]{Integer.valueOf(9)}), 0).show();
                            checkBox.setChecked(false);
                            AppMethodBeat.o(28184);
                            return;
                        } else {
                            if (obj.length() >= ((long) Math.max(bo.getInt(com.tencent.mm.m.g.Nu().getValue("InputLimitFileSize"), 104857600), 104857600))) {
                                t.makeText(NewFileExplorerUI.this.mController.ylL, NewFileExplorerUI.this.getString(R.string.bt_, new Object[]{bo.ga(r2)}), 0).show();
                                checkBox.setChecked(false);
                                AppMethodBeat.o(28184);
                                return;
                            }
                            if (a.aI(obj.getName())) {
                                com.tencent.mm.pluginsdk.ui.c.a ajK = com.tencent.mm.pluginsdk.ui.c.a.ajK(obj.getPath());
                                ajK.mSize = com.tencent.mm.m.b.Nd();
                                if (ajK.aAa() == 1) {
                                    t.makeText(NewFileExplorerUI.this.mController.ylL, NewFileExplorerUI.this.getString(R.string.f1s, new Object[]{bo.ga((long) com.tencent.mm.m.b.Nd())}), 0).show();
                                    checkBox.setChecked(false);
                                    AppMethodBeat.o(28184);
                                    return;
                                }
                            }
                            checkBox.setChecked(true);
                            a.this.vvd.add(obj);
                        }
                        NewFileExplorerUI.h(NewFileExplorerUI.this);
                        AppMethodBeat.o(28184);
                    }
                });
                view.setTag(bVar);
            }
            b bVar2 = (b) view.getTag();
            File file = this.vue[i];
            bVar2.gnB.setText(file.getName());
            if (file.isDirectory()) {
                bVar2.iqT.setImageResource(R.raw.app_attach_file_icon_folders);
                bVar2.vvg.setVisibility(4);
                bVar2.pxy.setVisibility(0);
                bVar2.enf.setVisibility(8);
                String[] list = file.list(new FilenameFilter() {
                    public final boolean accept(File file, String str) {
                        AppMethodBeat.i(28185);
                        if (str.startsWith(".")) {
                            AppMethodBeat.o(28185);
                            return false;
                        }
                        AppMethodBeat.o(28185);
                        return true;
                    }
                });
                int length = list != null ? list.length : 0;
                bVar2.pxy.setText(NewFileExplorerUI.this.getString(R.string.bsu, new Object[]{Integer.valueOf(length)}));
            } else {
                bVar2.vvg.setVisibility(0);
                bVar2.pxy.setVisibility(0);
                bVar2.enf.setVisibility(0);
                bVar2.pxy.setText(bo.ga(file.length()));
                bVar2.enf.setText(h.c(NewFileExplorerUI.this, file.lastModified(), true));
                if (ajX(file.getName())) {
                    String path = file.getPath();
                    Cursor query = NewFileExplorerUI.this.getContentResolver().query(Media.EXTERNAL_CONTENT_URI, new String[]{"_id"}, "_data=?", new String[]{path}, null);
                    if (query != null) {
                        if (query.moveToFirst()) {
                            int i2 = query.getInt(query.getColumnIndex("_id"));
                            query.close();
                            bitmap = Thumbnails.getThumbnail(NewFileExplorerUI.this.getContentResolver(), (long) i2, 3, null);
                        } else {
                            query.close();
                        }
                    }
                    if (bitmap != null) {
                        bVar2.iqT.setImageBitmap(bitmap);
                    } else {
                        bVar2.iqT.setImageResource(ajW(file.getName()));
                    }
                } else {
                    bVar2.iqT.setImageResource(ajW(file.getName()));
                }
            }
            bVar2.vvh.setChecked(this.vvd.contains(file));
            bVar2.vvg.setTag(Integer.valueOf(i));
            AppMethodBeat.o(28194);
            return view;
        }

        private static int ajW(String str) {
            AppMethodBeat.i(28195);
            String toLowerCase = str.toLowerCase();
            if (akb(toLowerCase)) {
                AppMethodBeat.o(28195);
                return R.raw.app_attach_file_icon_word;
            } else if (ajX(toLowerCase)) {
                AppMethodBeat.o(28195);
                return R.drawable.avp;
            } else if (aka(toLowerCase)) {
                AppMethodBeat.o(28195);
                return R.raw.app_attach_file_icon_rar;
            } else if (akf(toLowerCase)) {
                AppMethodBeat.o(28195);
                return R.raw.app_attach_file_icon_txt;
            } else if (akc(toLowerCase)) {
                AppMethodBeat.o(28195);
                return R.raw.app_attach_file_icon_pdf;
            } else if (akd(toLowerCase)) {
                AppMethodBeat.o(28195);
                return R.raw.app_attach_file_icon_ppt;
            } else if (ake(toLowerCase)) {
                AppMethodBeat.o(28195);
                return R.raw.app_attach_file_icon_excel;
            } else if (aH(toLowerCase)) {
                AppMethodBeat.o(28195);
                return R.raw.app_attach_file_icon_music;
            } else if (aI(toLowerCase)) {
                AppMethodBeat.o(28195);
                return R.raw.app_attach_file_icon_video;
            } else if (akh(toLowerCase)) {
                AppMethodBeat.o(28195);
                return R.raw.app_attach_file_icon_webpage;
            } else if (akg(toLowerCase)) {
                AppMethodBeat.o(28195);
                return R.raw.app_attach_file_icon_keynote;
            } else if (isNumber(toLowerCase)) {
                AppMethodBeat.o(28195);
                return R.raw.app_attach_file_icon_number;
            } else if (aki(toLowerCase)) {
                AppMethodBeat.o(28195);
                return R.raw.app_attach_file_icon_page;
            } else {
                AppMethodBeat.o(28195);
                return R.raw.app_attach_file_icon_unknow;
            }
        }

        private static boolean ajX(String str) {
            AppMethodBeat.i(28196);
            String toLowerCase = bo.nullAsNil(str).toLowerCase();
            if (VERSION.SDK_INT >= 28 && toLowerCase.endsWith(".heic")) {
                AppMethodBeat.o(28196);
                return true;
            } else if (toLowerCase.endsWith(".bmp") || toLowerCase.endsWith(".png") || toLowerCase.endsWith(FileUtils.PIC_POSTFIX_JPEG) || toLowerCase.endsWith(".jpeg") || toLowerCase.endsWith(".gif")) {
                AppMethodBeat.o(28196);
                return true;
            } else {
                AppMethodBeat.o(28196);
                return false;
            }
        }

        private static boolean aH(String str) {
            AppMethodBeat.i(28197);
            String toLowerCase = bo.nullAsNil(str).toLowerCase();
            if (toLowerCase.endsWith(".mp3") || toLowerCase.endsWith(".wma")) {
                AppMethodBeat.o(28197);
                return true;
            }
            AppMethodBeat.o(28197);
            return false;
        }

        static boolean aI(String str) {
            AppMethodBeat.i(28198);
            String toLowerCase = bo.nullAsNil(str).toLowerCase();
            if (toLowerCase.endsWith(VideoMaterialUtil.MP4_SUFFIX) || toLowerCase.endsWith(".rm")) {
                AppMethodBeat.o(28198);
                return true;
            }
            AppMethodBeat.o(28198);
            return false;
        }

        private static boolean aka(String str) {
            AppMethodBeat.i(28199);
            String toLowerCase = bo.nullAsNil(str).toLowerCase();
            if (toLowerCase.endsWith(".rar") || toLowerCase.endsWith(".zip") || toLowerCase.endsWith(".7z") || toLowerCase.endsWith("tar") || toLowerCase.endsWith(".iso")) {
                AppMethodBeat.o(28199);
                return true;
            }
            AppMethodBeat.o(28199);
            return false;
        }

        private static boolean akb(String str) {
            AppMethodBeat.i(28200);
            String toLowerCase = bo.nullAsNil(str).toLowerCase();
            if (toLowerCase.endsWith(".doc") || toLowerCase.endsWith(".docx") || toLowerCase.endsWith("wps")) {
                AppMethodBeat.o(28200);
                return true;
            }
            AppMethodBeat.o(28200);
            return false;
        }

        private static boolean akc(String str) {
            AppMethodBeat.i(28201);
            boolean endsWith = bo.nullAsNil(str).toLowerCase().endsWith(".pdf");
            AppMethodBeat.o(28201);
            return endsWith;
        }

        private static boolean akd(String str) {
            AppMethodBeat.i(28202);
            String toLowerCase = bo.nullAsNil(str).toLowerCase();
            if (toLowerCase.endsWith(".ppt") || toLowerCase.endsWith(".pptx")) {
                AppMethodBeat.o(28202);
                return true;
            }
            AppMethodBeat.o(28202);
            return false;
        }

        private static boolean ake(String str) {
            AppMethodBeat.i(28203);
            String toLowerCase = bo.nullAsNil(str).toLowerCase();
            if (toLowerCase.endsWith(".xls") || toLowerCase.endsWith(".xlsx")) {
                AppMethodBeat.o(28203);
                return true;
            }
            AppMethodBeat.o(28203);
            return false;
        }

        private static boolean akf(String str) {
            AppMethodBeat.i(28204);
            String toLowerCase = bo.nullAsNil(str).toLowerCase();
            if (toLowerCase.endsWith(".txt") || toLowerCase.endsWith(".rtf")) {
                AppMethodBeat.o(28204);
                return true;
            }
            AppMethodBeat.o(28204);
            return false;
        }

        private static boolean akg(String str) {
            AppMethodBeat.i(28205);
            boolean endsWith = bo.nullAsNil(str).toLowerCase().endsWith(".key");
            AppMethodBeat.o(28205);
            return endsWith;
        }

        private static boolean akh(String str) {
            AppMethodBeat.i(28206);
            boolean endsWith = bo.nullAsNil(str).toLowerCase().endsWith(".html");
            AppMethodBeat.o(28206);
            return endsWith;
        }

        private static boolean isNumber(String str) {
            AppMethodBeat.i(28207);
            boolean endsWith = bo.nullAsNil(str).toLowerCase().endsWith(".number");
            AppMethodBeat.o(28207);
            return endsWith;
        }

        private static boolean aki(String str) {
            AppMethodBeat.i(28208);
            boolean endsWith = bo.nullAsNil(str).toLowerCase().endsWith(".pages");
            AppMethodBeat.o(28208);
            return endsWith;
        }

        public final /* bridge */ /* synthetic */ Object getItem(int i) {
            return this.vue[i];
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.at(this, z);
    }

    public NewFileExplorerUI() {
        AppMethodBeat.i(28209);
        AppMethodBeat.o(28209);
    }

    static /* synthetic */ void c(NewFileExplorerUI newFileExplorerUI) {
        AppMethodBeat.i(28217);
        newFileExplorerUI.dlt();
        AppMethodBeat.o(28217);
    }

    static /* synthetic */ void d(NewFileExplorerUI newFileExplorerUI) {
        AppMethodBeat.i(28218);
        newFileExplorerUI.oV(true);
        AppMethodBeat.o(28218);
    }

    static /* synthetic */ void h(NewFileExplorerUI newFileExplorerUI) {
        AppMethodBeat.i(28220);
        newFileExplorerUI.cbv();
        AppMethodBeat.o(28220);
    }

    public final int getLayoutId() {
        return R.layout.ait;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.i(28210);
        super.onCreate(bundle);
        this.toUserName = getIntent().getStringExtra("TO_USER");
        this.gGW = (ListView) findViewById(R.id.dhq);
        this.vuV = new a();
        this.pxy = (TextView) findViewById(R.id.dhv);
        this.mode = getIntent().getIntExtra("explorer_mode", 0);
        if (this.mode == 1) {
            setMMTitle((int) R.string.bsz);
            setMMSubTitle(null);
            this.vuV.a(null, getIntent().getStringArrayListExtra("selected_file_lst"));
        } else {
            setMMTitle((int) R.string.bsw);
            setMMSubTitle(null);
            this.vuW = (TextView) findViewById(R.id.dhu);
            this.vuW.setText(R.string.bsw);
            this.vuV.c(new File(e.euQ), true);
            this.vuV.a(new File(e.euQ), null);
            if (this.vuV.getCount() == 0) {
                this.vuV.c(new File(e.eSl), false);
                this.vuV.a(new File(e.eSl), null);
                setMMTitle((int) R.string.bsx);
                this.vuW.setText(R.string.bsx);
            }
            findViewById(R.id.dht).setVisibility(0);
            findViewById(R.id.dht).setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    AppMethodBeat.i(28175);
                    if (NewFileExplorerUI.this.vuX != null) {
                        boolean z;
                        FileSelectorFolderView a = NewFileExplorerUI.this.vuX;
                        if (a.aej) {
                            z = false;
                        } else {
                            z = true;
                        }
                        a.hE(z);
                    }
                    AppMethodBeat.o(28175);
                }
            });
            this.vuX = (FileSelectorFolderView) findViewById(R.id.dhw);
            this.vuX.setListener(this.vuZ);
        }
        this.gGW.setAdapter(this.vuV);
        this.gGW.setOnItemClickListener(new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                AppMethodBeat.i(28176);
                File file = NewFileExplorerUI.this.vuV.vue[i];
                if (file.isDirectory()) {
                    NewFileExplorerUI.this.vuV.a(file, null);
                    NewFileExplorerUI.this.vuV.notifyDataSetChanged();
                    NewFileExplorerUI.c(NewFileExplorerUI.this);
                    AppMethodBeat.o(28176);
                    return;
                }
                a.a(NewFileExplorerUI.this, file.getPath(), com.tencent.mm.a.e.cv(file.getPath()), 1);
                AppMethodBeat.o(28176);
            }
        });
        this.gGW.setEmptyView(findViewById(R.id.dhr));
        setBackBtn(new OnMenuItemClickListener() {
            public final boolean onMenuItemClick(MenuItem menuItem) {
                AppMethodBeat.i(28177);
                NewFileExplorerUI.d(NewFileExplorerUI.this);
                AppMethodBeat.o(28177);
                return false;
            }
        }, this.mode == 0 ? R.raw.actionbar_quit_webview_icon : 0);
        if (this.mode == 0) {
            a(1, getString(R.string.tf), (OnMenuItemClickListener) new OnMenuItemClickListener() {
                public final boolean onMenuItemClick(MenuItem menuItem) {
                    AppMethodBeat.i(28178);
                    NewFileExplorerUI.e(NewFileExplorerUI.this);
                    AppMethodBeat.o(28178);
                    return true;
                }
            }, b.GREEN);
        }
        cbv();
        AppMethodBeat.o(28210);
    }

    public void onDestroy() {
        AppMethodBeat.i(28211);
        super.onDestroy();
        AppMethodBeat.o(28211);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.i(28212);
        if (i == 4) {
            oV(false);
            AppMethodBeat.o(28212);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.o(28212);
        return onKeyDown;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.i(28213);
        if (i == 0 && i2 == -1) {
            ArrayList stringArrayListExtra = intent.getStringArrayListExtra("selected_file_lst");
            if (!(stringArrayListExtra == null || this.vuV.vvd.size() == stringArrayListExtra.size())) {
                this.vuY.gud.dismiss();
                this.vuV.vvd.clear();
                Iterator it = stringArrayListExtra.iterator();
                while (it.hasNext()) {
                    this.vuV.vvd.add(new File((String) it.next()));
                }
                this.vuV.notifyDataSetChanged();
                dlt();
                cbv();
            }
            AppMethodBeat.o(28213);
            return;
        }
        if (i == 2) {
            a.a(this, i, i2, intent, true, R.string.b6t, R.string.b6u, 1);
        }
        AppMethodBeat.o(28213);
    }

    private void oV(boolean z) {
        AppMethodBeat.i(28214);
        if (this.mode != 0) {
            Intent intent = new Intent();
            intent.putStringArrayListExtra("selected_file_lst", this.vuV.dlu());
            intent.putStringArrayListExtra("key_select_video_list", this.vuV.dlw());
            intent.putStringArrayListExtra("CropImage_OutputPath_List", this.vuV.dlv());
            intent.putExtra("GalleryUI_ToUser", this.toUserName);
            setResult(-1, intent);
            finish();
            AppMethodBeat.o(28214);
        } else if (z || this.vuV.dlx() == null) {
            setResult(0);
            finish();
            AppMethodBeat.o(28214);
        } else {
            this.vuV.a(this.vuV.dlx(), null);
            this.vuV.notifyDataSetChanged();
            dlt();
            AppMethodBeat.o(28214);
        }
    }

    private void cbv() {
        AppMethodBeat.i(28215);
        int size = this.vuV.vvd.size();
        if (size > 0) {
            if (this.mode == 0) {
                updateOptionMenuText(1, getString(R.string.tf) + "(" + size + "/9)");
                enableOptionMenu(1, true);
            }
            this.pxy.setText(getString(R.string.bsy, new Object[]{bo.ga((long) this.vuV.cdf())}));
            this.pxy.setVisibility(0);
            AppMethodBeat.o(28215);
            return;
        }
        if (this.mode == 0) {
            updateOptionMenuText(1, getString(R.string.tf));
            enableOptionMenu(1, false);
        }
        this.pxy.setVisibility(8);
        AppMethodBeat.o(28215);
    }

    private void dlt() {
        AppMethodBeat.i(28216);
        if (!(this.vuV.vvb == null || this.vuV.vud == null)) {
            String replace = this.vuV.vud.getPath().replace(this.vuV.vvb.getPath(), "");
            if (replace.startsWith("/")) {
                replace = replace.substring(1);
            }
            if (replace.length() == 0) {
                replace = null;
            }
            setMMSubTitle(replace);
        }
        AppMethodBeat.o(28216);
    }

    static /* synthetic */ void e(NewFileExplorerUI newFileExplorerUI) {
        AppMethodBeat.i(28219);
        newFileExplorerUI.vuY = new com.tencent.mm.pluginsdk.ui.applet.g.a(newFileExplorerUI.mController.ylL);
        newFileExplorerUI.vuY.cx(newFileExplorerUI.toUserName);
        newFileExplorerUI.vuY.h(Boolean.TRUE);
        newFileExplorerUI.vuY.ajC(newFileExplorerUI.getString(R.string.qr) + newFileExplorerUI.getString(R.string.bst, new Object[]{Integer.valueOf(newFileExplorerUI.vuV.vvd.size()), bo.ga((long) newFileExplorerUI.vuV.cdf())}));
        newFileExplorerUI.vuY.a(new com.tencent.mm.ui.widget.a.c.a.b() {
            public final void bwF() {
                AppMethodBeat.i(28179);
                Intent intent = new Intent();
                intent.setClass(NewFileExplorerUI.this.mController.ylL, NewFileExplorerUI.class);
                intent.putExtra("explorer_mode", 1);
                intent.putStringArrayListExtra("selected_file_lst", NewFileExplorerUI.this.vuV.dlu());
                intent.putStringArrayListExtra("key_select_video_list", NewFileExplorerUI.this.vuV.dlw());
                intent.putStringArrayListExtra("CropImage_OutputPath_List", NewFileExplorerUI.this.vuV.dlv());
                intent.putExtra("GalleryUI_ToUser", NewFileExplorerUI.this.toUserName);
                NewFileExplorerUI.this.startActivityForResult(intent, 0);
                AppMethodBeat.o(28179);
            }
        });
        newFileExplorerUI.vuY.KQ(R.string.tf).a(new com.tencent.mm.pluginsdk.ui.applet.q.a() {
            public final void a(boolean z, String str, int i) {
                AppMethodBeat.i(28180);
                NewFileExplorerUI.this.aqX();
                if (z) {
                    Intent intent = new Intent();
                    intent.putStringArrayListExtra("selected_file_lst", NewFileExplorerUI.this.vuV.dlu());
                    intent.putStringArrayListExtra("key_select_video_list", NewFileExplorerUI.this.vuV.dlw());
                    intent.putStringArrayListExtra("CropImage_OutputPath_List", NewFileExplorerUI.this.vuV.dlv());
                    intent.putExtra("GalleryUI_ToUser", NewFileExplorerUI.this.toUserName);
                    intent.putExtra("with_text_content", str);
                    NewFileExplorerUI.this.setResult(-1, intent);
                    NewFileExplorerUI.this.finish();
                }
                AppMethodBeat.o(28180);
            }
        }).gud.show();
        AppMethodBeat.o(28219);
    }
}
