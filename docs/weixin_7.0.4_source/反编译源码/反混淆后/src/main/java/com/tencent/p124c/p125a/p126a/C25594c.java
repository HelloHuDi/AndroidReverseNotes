package com.tencent.p124c.p125a.p126a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.tencent.c.a.a.c */
final class C25594c {
    /* renamed from: s */
    static List<String> m40607s(File file) {
        AppMethodBeat.m2504i(125742);
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList arrayList = new ArrayList();
        while (true) {
            String readLine = bufferedReader.readLine();
            if (readLine != null) {
                arrayList.add(readLine.trim());
            } else {
                fileReader.close();
                bufferedReader.close();
                AppMethodBeat.m2505o(125742);
                return arrayList;
            }
        }
    }

    /* renamed from: cl */
    static File m40606cl(String str) {
        AppMethodBeat.m2504i(125743);
        File file = new File(str);
        if (file.exists()) {
            AppMethodBeat.m2505o(125743);
        } else {
            if (!file.getParentFile().exists()) {
                C25594c.m40606cl(file.getParentFile().getAbsolutePath());
            }
            file.mkdir();
            AppMethodBeat.m2505o(125743);
        }
        return file;
    }
}
