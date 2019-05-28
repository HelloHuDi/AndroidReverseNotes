package com.tencent.p177mm.pluginsdk.p597ui.tools;

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
import com.tencent.p177mm.C25738R;
import com.tencent.p177mm.boot.C1319a.C1318a;
import com.tencent.p177mm.compatible.util.C6457e;
import com.tencent.p177mm.p178a.C1173e;
import com.tencent.p177mm.p249m.C26373g;
import com.tencent.p177mm.p249m.C42164b;
import com.tencent.p177mm.p612ui.C5536q.C5535b;
import com.tencent.p177mm.p612ui.MMActivity;
import com.tencent.p177mm.p612ui.base.C23639t;
import com.tencent.p177mm.p612ui.base.C5271a;
import com.tencent.p177mm.p612ui.widget.p633a.C5653c.C5652a.C5649b;
import com.tencent.p177mm.platformtools.C9790g;
import com.tencent.p177mm.pluginsdk.p1079f.C14835h;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C35844g.C23273a;
import com.tencent.p177mm.pluginsdk.p597ui.applet.C40463q.C30111a;
import com.tencent.p177mm.pluginsdk.p597ui.p1509c.C35855a;
import com.tencent.p177mm.pluginsdk.p597ui.tools.FileSelectorFolderView.C23339a;
import com.tencent.p177mm.sdk.platformtools.C4990ab;
import com.tencent.p177mm.sdk.platformtools.C5046bo;
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

@C5271a(19)
/* renamed from: com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI */
public class NewFileExplorerUI extends MMActivity {
    private ListView gGW;
    private int mode = 0;
    private TextView pxy;
    private String toUserName;
    private C14963a vuV;
    private TextView vuW;
    private FileSelectorFolderView vuX;
    private C23273a vuY;
    private C23339a vuZ = new C301447();

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI$3 */
    class C149613 implements OnMenuItemClickListener {
        C149613() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(28177);
            NewFileExplorerUI.m47712d(NewFileExplorerUI.this);
            AppMethodBeat.m2505o(28177);
            return false;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI$6 */
    class C149626 implements C30111a {
        C149626() {
        }

        /* renamed from: a */
        public final void mo6399a(boolean z, String str, int i) {
            AppMethodBeat.m2504i(28180);
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
            AppMethodBeat.m2505o(28180);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI$a */
    public class C14963a extends BaseAdapter {
        private File vud;
        File[] vue = new File[0];
        private File vvb;
        private boolean vvc = false;
        private ArrayList<File> vvd = new ArrayList();

        /* renamed from: com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI$a$1 */
        class C149641 implements FileFilter {
            C149641() {
            }

            public final boolean accept(File file) {
                AppMethodBeat.m2504i(28182);
                if (file.isHidden()) {
                    AppMethodBeat.m2505o(28182);
                    return false;
                } else if (C14963a.this.vvc && file.isDirectory()) {
                    AppMethodBeat.m2505o(28182);
                    return false;
                } else {
                    AppMethodBeat.m2505o(28182);
                    return true;
                }
            }
        }

        /* renamed from: com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI$a$a */
        class C14965a {
            File file;
            long time;
            String vvf;

            private C14965a() {
            }

            /* synthetic */ C14965a(C14963a c14963a, byte b) {
                this();
            }
        }

        /* renamed from: com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI$a$b */
        class C14966b {
            public TextView enf;
            public TextView gnB;
            public ImageView iqT;
            public TextView pxy;
            public FrameLayout vvg;
            public CheckBox vvh;

            private C14966b() {
            }

            /* synthetic */ C14966b(C14963a c14963a, byte b) {
                this();
            }
        }

        /* renamed from: com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI$a$3 */
        class C149673 implements Comparator<C14965a> {
            C149673() {
            }

            public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
                C14965a c14965a = (C14965a) obj;
                C14965a c14965a2 = (C14965a) obj2;
                if (c14965a.time == c14965a2.time) {
                    return 0;
                }
                return c14965a.time > c14965a2.time ? -1 : 1;
            }
        }

        /* renamed from: com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI$a$4 */
        class C149684 implements OnClickListener {
            C149684() {
            }

            public final void onClick(View view) {
                AppMethodBeat.m2504i(28184);
                Object obj = C14963a.this.vue[((Integer) view.getTag()).intValue()];
                CheckBox checkBox = (CheckBox) view.findViewById(2131824075);
                if (C14963a.this.vvd.contains(obj)) {
                    C14963a.this.vvd.remove(obj);
                    checkBox.setChecked(false);
                } else if (C14963a.this.vvd.size() >= 9) {
                    C23639t.makeText(NewFileExplorerUI.this.mController.ylL, NewFileExplorerUI.this.getString(C25738R.string.bta, new Object[]{Integer.valueOf(9)}), 0).show();
                    checkBox.setChecked(false);
                    AppMethodBeat.m2505o(28184);
                    return;
                } else {
                    if (obj.length() >= ((long) Math.max(C5046bo.getInt(C26373g.m41964Nu().getValue("InputLimitFileSize"), 104857600), 104857600))) {
                        C23639t.makeText(NewFileExplorerUI.this.mController.ylL, NewFileExplorerUI.this.getString(C25738R.string.bt_, new Object[]{C5046bo.m7565ga(r2)}), 0).show();
                        checkBox.setChecked(false);
                        AppMethodBeat.m2505o(28184);
                        return;
                    }
                    if (C14963a.m23250aI(obj.getName())) {
                        C35855a ajK = C35855a.ajK(obj.getPath());
                        ajK.mSize = C42164b.m74342Nd();
                        if (ajK.aAa() == 1) {
                            C23639t.makeText(NewFileExplorerUI.this.mController.ylL, NewFileExplorerUI.this.getString(C25738R.string.f1s, new Object[]{C5046bo.m7565ga((long) C42164b.m74342Nd())}), 0).show();
                            checkBox.setChecked(false);
                            AppMethodBeat.m2505o(28184);
                            return;
                        }
                    }
                    checkBox.setChecked(true);
                    C14963a.this.vvd.add(obj);
                }
                NewFileExplorerUI.m47716h(NewFileExplorerUI.this);
                AppMethodBeat.m2505o(28184);
            }
        }

        /* renamed from: com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI$a$5 */
        class C149695 implements FilenameFilter {
            C149695() {
            }

            public final boolean accept(File file, String str) {
                AppMethodBeat.m2504i(28185);
                if (str.startsWith(".")) {
                    AppMethodBeat.m2505o(28185);
                    return false;
                }
                AppMethodBeat.m2505o(28185);
                return true;
            }
        }

        /* renamed from: com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI$a$2 */
        class C149702 implements Comparator<C14965a> {
            C149702() {
            }

            public final /* synthetic */ int compare(Object obj, Object obj2) {
                AppMethodBeat.m2504i(28183);
                int compareTo = ((C14965a) obj).vvf.compareTo(((C14965a) obj2).vvf);
                AppMethodBeat.m2505o(28183);
                return compareTo;
            }
        }

        public C14963a() {
            AppMethodBeat.m2504i(28186);
            AppMethodBeat.m2505o(28186);
        }

        /* renamed from: c */
        public final void mo27313c(File file, boolean z) {
            this.vvb = file;
            this.vvc = z;
        }

        /* renamed from: a */
        public final void mo27312a(File file, List<String> list) {
            int i = 0;
            AppMethodBeat.m2504i(28187);
            this.vud = file;
            if (this.vud != null && this.vud.canRead() && this.vud.isDirectory()) {
                this.vue = this.vud.listFiles(new C149641());
                if (this.vue == null) {
                    this.vue = new File[0];
                }
                if (this.vue.length > 0) {
                    m23248a(this.vue);
                    AppMethodBeat.m2505o(28187);
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
            AppMethodBeat.m2505o(28187);
        }

        public final int cdf() {
            AppMethodBeat.m2504i(28188);
            int i = 0;
            Iterator it = this.vvd.iterator();
            while (true) {
                int i2 = i;
                if (it.hasNext()) {
                    i = (int) (((File) it.next()).length() + ((long) i2));
                } else {
                    AppMethodBeat.m2505o(28188);
                    return i2;
                }
            }
        }

        public final ArrayList<String> dlu() {
            AppMethodBeat.m2504i(28189);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.vvd.iterator();
            while (it.hasNext()) {
                File file = (File) it.next();
                if (!(C14963a.ajX(file.getName()) || C14963a.m23250aI(file.getName()))) {
                    arrayList.add(file.getPath());
                }
            }
            AppMethodBeat.m2505o(28189);
            return arrayList;
        }

        public final ArrayList<String> dlv() {
            AppMethodBeat.m2504i(28190);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.vvd.iterator();
            while (it.hasNext()) {
                File file = (File) it.next();
                if (C14963a.ajX(file.getName())) {
                    arrayList.add(file.getPath());
                }
            }
            AppMethodBeat.m2505o(28190);
            return arrayList;
        }

        public final ArrayList<String> dlw() {
            AppMethodBeat.m2504i(28191);
            ArrayList arrayList = new ArrayList();
            Iterator it = this.vvd.iterator();
            while (it.hasNext()) {
                File file = (File) it.next();
                if (C14963a.m23250aI(file.getName())) {
                    arrayList.add(file.getPath());
                }
            }
            AppMethodBeat.m2505o(28191);
            return arrayList;
        }

        public final File dlx() {
            AppMethodBeat.m2504i(28192);
            if (this.vud.hashCode() == this.vvb.hashCode()) {
                AppMethodBeat.m2505o(28192);
                return null;
            }
            File parentFile = this.vud.getParentFile();
            AppMethodBeat.m2505o(28192);
            return parentFile;
        }

        /* renamed from: a */
        private void m23248a(File[] fileArr) {
            byte b = (byte) 0;
            AppMethodBeat.m2504i(28193);
            if (fileArr == null || fileArr.length == 0) {
                AppMethodBeat.m2505o(28193);
                return;
            }
            int i;
            ArrayList arrayList = new ArrayList();
            ArrayList<C14965a> arrayList2 = new ArrayList();
            for (File file : fileArr) {
                C14965a c14965a = new C14965a(this, (byte) 0);
                c14965a.file = file;
                c14965a.time = file.lastModified();
                if (file.isDirectory()) {
                    c14965a.vvf = C9790g.m17432vo(file.getName()).toUpperCase();
                    arrayList.add(c14965a);
                } else {
                    arrayList2.add(c14965a);
                }
            }
            Collections.sort(arrayList, new C149702());
            Collections.sort(arrayList2, new C149673());
            Iterator it = arrayList.iterator();
            while (true) {
                i = b;
                if (!it.hasNext()) {
                    break;
                }
                fileArr[i] = ((C14965a) it.next()).file;
                b = i + 1;
            }
            for (C14965a c14965a2 : arrayList2) {
                fileArr[i] = c14965a2.file;
                i++;
            }
            AppMethodBeat.m2505o(28193);
        }

        public final int getCount() {
            return this.vue.length;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            Bitmap bitmap = null;
            AppMethodBeat.m2504i(28194);
            if (view == null) {
                view = View.inflate(viewGroup.getContext(), 2130969570, null);
                C14966b c14966b = new C14966b(this, (byte) 0);
                c14966b.vvg = (FrameLayout) view.findViewById(2131824073);
                c14966b.vvh = (CheckBox) c14966b.vvg.findViewById(2131824075);
                c14966b.iqT = (ImageView) view.findViewById(2131823474);
                c14966b.gnB = (TextView) view.findViewById(2131823564);
                c14966b.pxy = (TextView) view.findViewById(2131823324);
                c14966b.enf = (TextView) view.findViewById(2131824074);
                c14966b.vvg.setOnClickListener(new C149684());
                view.setTag(c14966b);
            }
            C14966b c14966b2 = (C14966b) view.getTag();
            File file = this.vue[i];
            c14966b2.gnB.setText(file.getName());
            if (file.isDirectory()) {
                c14966b2.iqT.setImageResource(C1318a.app_attach_file_icon_folders);
                c14966b2.vvg.setVisibility(4);
                c14966b2.pxy.setVisibility(0);
                c14966b2.enf.setVisibility(8);
                String[] list = file.list(new C149695());
                int length = list != null ? list.length : 0;
                c14966b2.pxy.setText(NewFileExplorerUI.this.getString(C25738R.string.bsu, new Object[]{Integer.valueOf(length)}));
            } else {
                c14966b2.vvg.setVisibility(0);
                c14966b2.pxy.setVisibility(0);
                c14966b2.enf.setVisibility(0);
                c14966b2.pxy.setText(C5046bo.m7565ga(file.length()));
                c14966b2.enf.setText(C14835h.m23089c(NewFileExplorerUI.this, file.lastModified(), true));
                if (C14963a.ajX(file.getName())) {
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
                        c14966b2.iqT.setImageBitmap(bitmap);
                    } else {
                        c14966b2.iqT.setImageResource(C14963a.ajW(file.getName()));
                    }
                } else {
                    c14966b2.iqT.setImageResource(C14963a.ajW(file.getName()));
                }
            }
            c14966b2.vvh.setChecked(this.vvd.contains(file));
            c14966b2.vvg.setTag(Integer.valueOf(i));
            AppMethodBeat.m2505o(28194);
            return view;
        }

        private static int ajW(String str) {
            AppMethodBeat.m2504i(28195);
            String toLowerCase = str.toLowerCase();
            if (C14963a.akb(toLowerCase)) {
                AppMethodBeat.m2505o(28195);
                return C1318a.app_attach_file_icon_word;
            } else if (C14963a.ajX(toLowerCase)) {
                AppMethodBeat.m2505o(28195);
                return C25738R.drawable.avp;
            } else if (C14963a.aka(toLowerCase)) {
                AppMethodBeat.m2505o(28195);
                return C1318a.app_attach_file_icon_rar;
            } else if (C14963a.akf(toLowerCase)) {
                AppMethodBeat.m2505o(28195);
                return C1318a.app_attach_file_icon_txt;
            } else if (C14963a.akc(toLowerCase)) {
                AppMethodBeat.m2505o(28195);
                return C1318a.app_attach_file_icon_pdf;
            } else if (C14963a.akd(toLowerCase)) {
                AppMethodBeat.m2505o(28195);
                return C1318a.app_attach_file_icon_ppt;
            } else if (C14963a.ake(toLowerCase)) {
                AppMethodBeat.m2505o(28195);
                return C1318a.app_attach_file_icon_excel;
            } else if (C14963a.m23249aH(toLowerCase)) {
                AppMethodBeat.m2505o(28195);
                return C1318a.app_attach_file_icon_music;
            } else if (C14963a.m23250aI(toLowerCase)) {
                AppMethodBeat.m2505o(28195);
                return C1318a.app_attach_file_icon_video;
            } else if (C14963a.akh(toLowerCase)) {
                AppMethodBeat.m2505o(28195);
                return C1318a.app_attach_file_icon_webpage;
            } else if (C14963a.akg(toLowerCase)) {
                AppMethodBeat.m2505o(28195);
                return C1318a.app_attach_file_icon_keynote;
            } else if (C14963a.isNumber(toLowerCase)) {
                AppMethodBeat.m2505o(28195);
                return C1318a.app_attach_file_icon_number;
            } else if (C14963a.aki(toLowerCase)) {
                AppMethodBeat.m2505o(28195);
                return C1318a.app_attach_file_icon_page;
            } else {
                AppMethodBeat.m2505o(28195);
                return C1318a.app_attach_file_icon_unknow;
            }
        }

        private static boolean ajX(String str) {
            AppMethodBeat.m2504i(28196);
            String toLowerCase = C5046bo.nullAsNil(str).toLowerCase();
            if (VERSION.SDK_INT >= 28 && toLowerCase.endsWith(".heic")) {
                AppMethodBeat.m2505o(28196);
                return true;
            } else if (toLowerCase.endsWith(".bmp") || toLowerCase.endsWith(".png") || toLowerCase.endsWith(FileUtils.PIC_POSTFIX_JPEG) || toLowerCase.endsWith(".jpeg") || toLowerCase.endsWith(".gif")) {
                AppMethodBeat.m2505o(28196);
                return true;
            } else {
                AppMethodBeat.m2505o(28196);
                return false;
            }
        }

        /* renamed from: aH */
        private static boolean m23249aH(String str) {
            AppMethodBeat.m2504i(28197);
            String toLowerCase = C5046bo.nullAsNil(str).toLowerCase();
            if (toLowerCase.endsWith(".mp3") || toLowerCase.endsWith(".wma")) {
                AppMethodBeat.m2505o(28197);
                return true;
            }
            AppMethodBeat.m2505o(28197);
            return false;
        }

        /* renamed from: aI */
        static boolean m23250aI(String str) {
            AppMethodBeat.m2504i(28198);
            String toLowerCase = C5046bo.nullAsNil(str).toLowerCase();
            if (toLowerCase.endsWith(VideoMaterialUtil.MP4_SUFFIX) || toLowerCase.endsWith(".rm")) {
                AppMethodBeat.m2505o(28198);
                return true;
            }
            AppMethodBeat.m2505o(28198);
            return false;
        }

        private static boolean aka(String str) {
            AppMethodBeat.m2504i(28199);
            String toLowerCase = C5046bo.nullAsNil(str).toLowerCase();
            if (toLowerCase.endsWith(".rar") || toLowerCase.endsWith(".zip") || toLowerCase.endsWith(".7z") || toLowerCase.endsWith("tar") || toLowerCase.endsWith(".iso")) {
                AppMethodBeat.m2505o(28199);
                return true;
            }
            AppMethodBeat.m2505o(28199);
            return false;
        }

        private static boolean akb(String str) {
            AppMethodBeat.m2504i(28200);
            String toLowerCase = C5046bo.nullAsNil(str).toLowerCase();
            if (toLowerCase.endsWith(".doc") || toLowerCase.endsWith(".docx") || toLowerCase.endsWith("wps")) {
                AppMethodBeat.m2505o(28200);
                return true;
            }
            AppMethodBeat.m2505o(28200);
            return false;
        }

        private static boolean akc(String str) {
            AppMethodBeat.m2504i(28201);
            boolean endsWith = C5046bo.nullAsNil(str).toLowerCase().endsWith(".pdf");
            AppMethodBeat.m2505o(28201);
            return endsWith;
        }

        private static boolean akd(String str) {
            AppMethodBeat.m2504i(28202);
            String toLowerCase = C5046bo.nullAsNil(str).toLowerCase();
            if (toLowerCase.endsWith(".ppt") || toLowerCase.endsWith(".pptx")) {
                AppMethodBeat.m2505o(28202);
                return true;
            }
            AppMethodBeat.m2505o(28202);
            return false;
        }

        private static boolean ake(String str) {
            AppMethodBeat.m2504i(28203);
            String toLowerCase = C5046bo.nullAsNil(str).toLowerCase();
            if (toLowerCase.endsWith(".xls") || toLowerCase.endsWith(".xlsx")) {
                AppMethodBeat.m2505o(28203);
                return true;
            }
            AppMethodBeat.m2505o(28203);
            return false;
        }

        private static boolean akf(String str) {
            AppMethodBeat.m2504i(28204);
            String toLowerCase = C5046bo.nullAsNil(str).toLowerCase();
            if (toLowerCase.endsWith(".txt") || toLowerCase.endsWith(".rtf")) {
                AppMethodBeat.m2505o(28204);
                return true;
            }
            AppMethodBeat.m2505o(28204);
            return false;
        }

        private static boolean akg(String str) {
            AppMethodBeat.m2504i(28205);
            boolean endsWith = C5046bo.nullAsNil(str).toLowerCase().endsWith(".key");
            AppMethodBeat.m2505o(28205);
            return endsWith;
        }

        private static boolean akh(String str) {
            AppMethodBeat.m2504i(28206);
            boolean endsWith = C5046bo.nullAsNil(str).toLowerCase().endsWith(".html");
            AppMethodBeat.m2505o(28206);
            return endsWith;
        }

        private static boolean isNumber(String str) {
            AppMethodBeat.m2504i(28207);
            boolean endsWith = C5046bo.nullAsNil(str).toLowerCase().endsWith(".number");
            AppMethodBeat.m2505o(28207);
            return endsWith;
        }

        private static boolean aki(String str) {
            AppMethodBeat.m2504i(28208);
            boolean endsWith = C5046bo.nullAsNil(str).toLowerCase().endsWith(".pages");
            AppMethodBeat.m2505o(28208);
            return endsWith;
        }

        public final /* bridge */ /* synthetic */ Object getItem(int i) {
            return this.vue[i];
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI$2 */
    class C301402 implements OnItemClickListener {
        C301402() {
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            AppMethodBeat.m2504i(28176);
            File file = NewFileExplorerUI.this.vuV.vue[i];
            if (file.isDirectory()) {
                NewFileExplorerUI.this.vuV.mo27312a(file, null);
                NewFileExplorerUI.this.vuV.notifyDataSetChanged();
                NewFileExplorerUI.m47711c(NewFileExplorerUI.this);
                AppMethodBeat.m2505o(28176);
                return;
            }
            C44094a.m79368a(NewFileExplorerUI.this, file.getPath(), C1173e.m2563cv(file.getPath()), 1);
            AppMethodBeat.m2505o(28176);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI$4 */
    class C301414 implements OnMenuItemClickListener {
        C301414() {
        }

        public final boolean onMenuItemClick(MenuItem menuItem) {
            AppMethodBeat.m2504i(28178);
            NewFileExplorerUI.m47713e(NewFileExplorerUI.this);
            AppMethodBeat.m2505o(28178);
            return true;
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI$5 */
    class C301425 implements C5649b {
        C301425() {
        }

        public final void bwF() {
            AppMethodBeat.m2504i(28179);
            Intent intent = new Intent();
            intent.setClass(NewFileExplorerUI.this.mController.ylL, NewFileExplorerUI.class);
            intent.putExtra("explorer_mode", 1);
            intent.putStringArrayListExtra("selected_file_lst", NewFileExplorerUI.this.vuV.dlu());
            intent.putStringArrayListExtra("key_select_video_list", NewFileExplorerUI.this.vuV.dlw());
            intent.putStringArrayListExtra("CropImage_OutputPath_List", NewFileExplorerUI.this.vuV.dlv());
            intent.putExtra("GalleryUI_ToUser", NewFileExplorerUI.this.toUserName);
            NewFileExplorerUI.this.startActivityForResult(intent, 0);
            AppMethodBeat.m2505o(28179);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI$1 */
    class C301431 implements OnClickListener {
        C301431() {
        }

        public final void onClick(View view) {
            AppMethodBeat.m2504i(28175);
            if (NewFileExplorerUI.this.vuX != null) {
                boolean z;
                FileSelectorFolderView a = NewFileExplorerUI.this.vuX;
                if (a.aej) {
                    z = false;
                } else {
                    z = true;
                }
                a.mo39073hE(z);
            }
            AppMethodBeat.m2505o(28175);
        }
    }

    /* renamed from: com.tencent.mm.pluginsdk.ui.tools.NewFileExplorerUI$7 */
    class C301447 implements C23339a {
        C301447() {
        }

        /* renamed from: Ls */
        public final void mo39076Ls(int i) {
            AppMethodBeat.m2504i(28181);
            C4990ab.m7417i("MicroMsg.FileExplorerUI", "position: %d", Integer.valueOf(i));
            if (i == 0) {
                NewFileExplorerUI.this.setMMTitle((int) C25738R.string.bsw);
                NewFileExplorerUI.this.setMMSubTitle(null);
                NewFileExplorerUI.this.vuW = (TextView) NewFileExplorerUI.this.findViewById(2131826346);
                NewFileExplorerUI.this.vuW.setText(C25738R.string.bsw);
                NewFileExplorerUI.this.vuV.mo27313c(new File(C6457e.euQ), true);
                NewFileExplorerUI.this.vuV.mo27312a(new File(C6457e.euQ), null);
            } else {
                NewFileExplorerUI.this.vuV.mo27313c(new File(C6457e.eSl), false);
                NewFileExplorerUI.this.vuV.mo27312a(new File(C6457e.eSl), null);
                NewFileExplorerUI.this.setMMTitle((int) C25738R.string.bsx);
                NewFileExplorerUI.this.vuW.setText(C25738R.string.bsx);
            }
            NewFileExplorerUI.this.vuV.notifyDataSetChanged();
            NewFileExplorerUI.m47711c(NewFileExplorerUI.this);
            AppMethodBeat.m2505o(28181);
        }
    }

    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        AppMethodBeat.m2503at(this, z);
    }

    public NewFileExplorerUI() {
        AppMethodBeat.m2504i(28209);
        AppMethodBeat.m2505o(28209);
    }

    /* renamed from: c */
    static /* synthetic */ void m47711c(NewFileExplorerUI newFileExplorerUI) {
        AppMethodBeat.m2504i(28217);
        newFileExplorerUI.dlt();
        AppMethodBeat.m2505o(28217);
    }

    /* renamed from: d */
    static /* synthetic */ void m47712d(NewFileExplorerUI newFileExplorerUI) {
        AppMethodBeat.m2504i(28218);
        newFileExplorerUI.m47717oV(true);
        AppMethodBeat.m2505o(28218);
    }

    /* renamed from: h */
    static /* synthetic */ void m47716h(NewFileExplorerUI newFileExplorerUI) {
        AppMethodBeat.m2504i(28220);
        newFileExplorerUI.cbv();
        AppMethodBeat.m2505o(28220);
    }

    public final int getLayoutId() {
        return 2130970301;
    }

    public void onCreate(Bundle bundle) {
        AppMethodBeat.m2504i(28210);
        super.onCreate(bundle);
        this.toUserName = getIntent().getStringExtra("TO_USER");
        this.gGW = (ListView) findViewById(2131826342);
        this.vuV = new C14963a();
        this.pxy = (TextView) findViewById(2131826347);
        this.mode = getIntent().getIntExtra("explorer_mode", 0);
        if (this.mode == 1) {
            setMMTitle((int) C25738R.string.bsz);
            setMMSubTitle(null);
            this.vuV.mo27312a(null, getIntent().getStringArrayListExtra("selected_file_lst"));
        } else {
            setMMTitle((int) C25738R.string.bsw);
            setMMSubTitle(null);
            this.vuW = (TextView) findViewById(2131826346);
            this.vuW.setText(C25738R.string.bsw);
            this.vuV.mo27313c(new File(C6457e.euQ), true);
            this.vuV.mo27312a(new File(C6457e.euQ), null);
            if (this.vuV.getCount() == 0) {
                this.vuV.mo27313c(new File(C6457e.eSl), false);
                this.vuV.mo27312a(new File(C6457e.eSl), null);
                setMMTitle((int) C25738R.string.bsx);
                this.vuW.setText(C25738R.string.bsx);
            }
            findViewById(2131826345).setVisibility(0);
            findViewById(2131826345).setOnClickListener(new C301431());
            this.vuX = (FileSelectorFolderView) findViewById(2131826348);
            this.vuX.setListener(this.vuZ);
        }
        this.gGW.setAdapter(this.vuV);
        this.gGW.setOnItemClickListener(new C301402());
        this.gGW.setEmptyView(findViewById(2131826343));
        setBackBtn(new C149613(), this.mode == 0 ? C1318a.actionbar_quit_webview_icon : 0);
        if (this.mode == 0) {
            mo17379a(1, getString(C25738R.string.f9221tf), (OnMenuItemClickListener) new C301414(), C5535b.GREEN);
        }
        cbv();
        AppMethodBeat.m2505o(28210);
    }

    public void onDestroy() {
        AppMethodBeat.m2504i(28211);
        super.onDestroy();
        AppMethodBeat.m2505o(28211);
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        AppMethodBeat.m2504i(28212);
        if (i == 4) {
            m47717oV(false);
            AppMethodBeat.m2505o(28212);
            return true;
        }
        boolean onKeyDown = super.onKeyDown(i, keyEvent);
        AppMethodBeat.m2505o(28212);
        return onKeyDown;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        AppMethodBeat.m2504i(28213);
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
            AppMethodBeat.m2505o(28213);
            return;
        }
        if (i == 2) {
            C44094a.m79367a(this, i, i2, intent, true, C25738R.string.b6t, C25738R.string.b6u, 1);
        }
        AppMethodBeat.m2505o(28213);
    }

    /* renamed from: oV */
    private void m47717oV(boolean z) {
        AppMethodBeat.m2504i(28214);
        if (this.mode != 0) {
            Intent intent = new Intent();
            intent.putStringArrayListExtra("selected_file_lst", this.vuV.dlu());
            intent.putStringArrayListExtra("key_select_video_list", this.vuV.dlw());
            intent.putStringArrayListExtra("CropImage_OutputPath_List", this.vuV.dlv());
            intent.putExtra("GalleryUI_ToUser", this.toUserName);
            setResult(-1, intent);
            finish();
            AppMethodBeat.m2505o(28214);
        } else if (z || this.vuV.dlx() == null) {
            setResult(0);
            finish();
            AppMethodBeat.m2505o(28214);
        } else {
            this.vuV.mo27312a(this.vuV.dlx(), null);
            this.vuV.notifyDataSetChanged();
            dlt();
            AppMethodBeat.m2505o(28214);
        }
    }

    private void cbv() {
        AppMethodBeat.m2504i(28215);
        int size = this.vuV.vvd.size();
        if (size > 0) {
            if (this.mode == 0) {
                updateOptionMenuText(1, getString(C25738R.string.f9221tf) + "(" + size + "/9)");
                enableOptionMenu(1, true);
            }
            this.pxy.setText(getString(C25738R.string.bsy, new Object[]{C5046bo.m7565ga((long) this.vuV.cdf())}));
            this.pxy.setVisibility(0);
            AppMethodBeat.m2505o(28215);
            return;
        }
        if (this.mode == 0) {
            updateOptionMenuText(1, getString(C25738R.string.f9221tf));
            enableOptionMenu(1, false);
        }
        this.pxy.setVisibility(8);
        AppMethodBeat.m2505o(28215);
    }

    private void dlt() {
        AppMethodBeat.m2504i(28216);
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
        AppMethodBeat.m2505o(28216);
    }

    /* renamed from: e */
    static /* synthetic */ void m47713e(NewFileExplorerUI newFileExplorerUI) {
        AppMethodBeat.m2504i(28219);
        newFileExplorerUI.vuY = new C23273a(newFileExplorerUI.mController.ylL);
        newFileExplorerUI.vuY.mo38972cx(newFileExplorerUI.toUserName);
        newFileExplorerUI.vuY.mo38977h(Boolean.TRUE);
        newFileExplorerUI.vuY.ajC(newFileExplorerUI.getString(C25738R.string.f9140qr) + newFileExplorerUI.getString(C25738R.string.bst, new Object[]{Integer.valueOf(newFileExplorerUI.vuV.vvd.size()), C5046bo.m7565ga((long) newFileExplorerUI.vuV.cdf())}));
        newFileExplorerUI.vuY.mo38967a(new C301425());
        newFileExplorerUI.vuY.mo38965KQ(C25738R.string.f9221tf).mo38966a(new C149626()).gud.show();
        AppMethodBeat.m2505o(28219);
    }
}
