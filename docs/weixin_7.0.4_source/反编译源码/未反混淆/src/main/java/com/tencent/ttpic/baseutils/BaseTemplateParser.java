package com.tencent.ttpic.baseutils;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.ttpic.device.DeviceCoffee;
import com.tencent.ttpic.json.XML;
import com.tencent.ttpic.util.Coffee;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import org.json.JSONObject;
import org.json.JSONTokener;

public class BaseTemplateParser {
    public static final String POSTFIX_DAT = "dat";
    private static final String POSTFIX_JSON = "json";
    public static final String POSTFIX_ORIG = "xml";
    private static final String POSTFIX_TXT = "txt";
    public static final String POSTFIX_WMC = "wmc";

    /* JADX WARNING: Removed duplicated region for block: B:132:0x0164  */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x0042 A:{SYNTHETIC, Splitter:B:13:0x0042} */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x00c6 A:{SYNTHETIC, Splitter:B:71:0x00c6} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00cb A:{Catch:{ IOException -> 0x00d9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x00d0 A:{Catch:{ IOException -> 0x00d9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x00d5 A:{Catch:{ IOException -> 0x00d9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00b0 A:{SYNTHETIC, Splitter:B:62:0x00b0} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00eb A:{SYNTHETIC, Splitter:B:86:0x00eb} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f0 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00f5 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x00fa A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00eb A:{SYNTHETIC, Splitter:B:86:0x00eb} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f0 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00f5 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x00fa A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00eb A:{SYNTHETIC, Splitter:B:86:0x00eb} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f0 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00f5 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x00fa A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0065 A:{SYNTHETIC, Splitter:B:28:0x0065} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006a A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006f A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074 A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00eb A:{SYNTHETIC, Splitter:B:86:0x00eb} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f0 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00f5 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x00fa A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0065 A:{SYNTHETIC, Splitter:B:28:0x0065} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006a A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006f A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074 A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00eb A:{SYNTHETIC, Splitter:B:86:0x00eb} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f0 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00f5 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x00fa A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0065 A:{SYNTHETIC, Splitter:B:28:0x0065} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006a A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006f A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074 A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00eb A:{SYNTHETIC, Splitter:B:86:0x00eb} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f0 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00f5 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x00fa A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0065 A:{SYNTHETIC, Splitter:B:28:0x0065} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006a A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006f A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074 A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00eb A:{SYNTHETIC, Splitter:B:86:0x00eb} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f0 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00f5 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x00fa A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0065 A:{SYNTHETIC, Splitter:B:28:0x0065} */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x006a A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x006f A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0074 A:{Catch:{ IOException -> 0x00de }} */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x00eb A:{SYNTHETIC, Splitter:B:86:0x00eb} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x00f0 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x00f5 A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x00fa A:{Catch:{ IOException -> 0x0101 }} */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00b0 A:{SYNTHETIC, Splitter:B:62:0x00b0} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String parseCameraAttrsFile(Context context, String str, String str2, String str3) {
        FileInputStream fileInputStream;
        InputStream inputStream;
        Throwable e;
        InputStream inputStream2;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        String str4;
        BufferedReader bufferedReader2;
        InputStreamReader inputStreamReader2;
        Throwable th;
        InputStream inputStream3;
        AppMethodBeat.i(49582);
        LogUtils.v("ContentValues", "[parseCameraAttrsFile] filePath = ".concat(String.valueOf(str)));
        try {
            File file = new File(str);
            InputStream fileInputStream2;
            InputStream drinkACupOfCoffeeForCamera;
            if (file.exists() && file.isFile()) {
                LogUtils.v("ContentValues", "[parseCameraAttrsFile] parseFile file exists and isFile");
                fileInputStream2 = new FileInputStream(file);
                try {
                    drinkACupOfCoffeeForCamera = drinkACupOfCoffeeForCamera(fileInputStream2, str2, str3);
                    try {
                        IOUtils.closeQuietly(fileInputStream2);
                        fileInputStream = fileInputStream2;
                        inputStream = drinkACupOfCoffeeForCamera;
                    } catch (Exception e2) {
                        e = e2;
                        inputStream2 = fileInputStream2;
                        inputStreamReader = null;
                        bufferedReader = null;
                        inputStream = drinkACupOfCoffeeForCamera;
                        LogUtils.e(e);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e3) {
                                LogUtils.e(e3);
                                str4 = null;
                            }
                        }
                        if (inputStreamReader != null) {
                            inputStreamReader.close();
                        }
                        if (inputStream != null) {
                            inputStream.close();
                        }
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        str4 = null;
                        AppMethodBeat.o(49582);
                        return str4;
                    } catch (Throwable th2) {
                        e = th2;
                        inputStream2 = fileInputStream2;
                        inputStreamReader = null;
                        bufferedReader = null;
                        inputStream = drinkACupOfCoffeeForCamera;
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.o(49582);
                        throw e;
                    }
                } catch (Exception e4) {
                    e = e4;
                    inputStream2 = fileInputStream2;
                    inputStreamReader = null;
                    bufferedReader = null;
                    inputStream = null;
                } catch (Throwable th3) {
                    e = th3;
                    inputStream2 = fileInputStream2;
                    inputStreamReader = null;
                    bufferedReader = null;
                    inputStream = null;
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.o(49582);
                    throw e;
                }
            }
            InputStream open;
            LogUtils.v("ContentValues", "[parseCameraAttrsFile] parseFile file is in Assets directory");
            if (context != null) {
                try {
                    open = context.getAssets().open(str);
                    try {
                        fileInputStream2 = drinkACupOfCoffeeForCamera(open, str2, str3);
                        try {
                            IOUtils.closeQuietly(open);
                            drinkACupOfCoffeeForCamera = fileInputStream2;
                        } catch (IOException e5) {
                            if (open != null) {
                                try {
                                    open.close();
                                    fileInputStream = null;
                                    inputStream = fileInputStream2;
                                } catch (Exception e6) {
                                    e = e6;
                                    fileInputStream = null;
                                    inputStreamReader = null;
                                    bufferedReader = null;
                                    inputStream = fileInputStream2;
                                    try {
                                        LogUtils.e(e);
                                        if (bufferedReader != null) {
                                        }
                                        if (inputStreamReader != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (fileInputStream != null) {
                                        }
                                        str4 = null;
                                        AppMethodBeat.o(49582);
                                        return str4;
                                    } catch (Throwable th4) {
                                        e = th4;
                                        if (bufferedReader != null) {
                                        }
                                        if (inputStreamReader != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (fileInputStream != null) {
                                        }
                                        AppMethodBeat.o(49582);
                                        throw e;
                                    }
                                } catch (Throwable th5) {
                                    e = th5;
                                    fileInputStream = null;
                                    inputStreamReader = null;
                                    bufferedReader = null;
                                    inputStream = fileInputStream2;
                                    if (bufferedReader != null) {
                                    }
                                    if (inputStreamReader != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (fileInputStream != null) {
                                    }
                                    AppMethodBeat.o(49582);
                                    throw e;
                                }
                            }
                            fileInputStream = null;
                            inputStream = fileInputStream2;
                            if (inputStream == null) {
                            }
                            if (bufferedReader2 != null) {
                            }
                            if (inputStreamReader2 != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (fileInputStream != null) {
                            }
                            AppMethodBeat.o(49582);
                            return str4;
                        } catch (Throwable th6) {
                            th = th6;
                            inputStream3 = open;
                            drinkACupOfCoffeeForCamera = fileInputStream2;
                            if (inputStream3 != null) {
                                inputStream3.close();
                            }
                            AppMethodBeat.o(49582);
                            throw th;
                        }
                    } catch (IOException e7) {
                        fileInputStream2 = null;
                    } catch (Throwable th7) {
                        th = th7;
                        inputStream3 = open;
                        drinkACupOfCoffeeForCamera = null;
                        if (inputStream3 != null) {
                        }
                        AppMethodBeat.o(49582);
                        throw th;
                    }
                } catch (IOException e8) {
                    open = null;
                    fileInputStream2 = null;
                } catch (Throwable e9) {
                    th = e9;
                    inputStream3 = null;
                    drinkACupOfCoffeeForCamera = null;
                    if (inputStream3 != null) {
                    }
                    AppMethodBeat.o(49582);
                    throw th;
                }
            }
            open = null;
            drinkACupOfCoffeeForCamera = null;
            if (open != null) {
                try {
                    open.close();
                    fileInputStream = null;
                    inputStream = drinkACupOfCoffeeForCamera;
                } catch (Exception e10) {
                    e9 = e10;
                    fileInputStream = null;
                    inputStreamReader = null;
                    bufferedReader = null;
                    inputStream = drinkACupOfCoffeeForCamera;
                    LogUtils.e(e9);
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    str4 = null;
                    AppMethodBeat.o(49582);
                    return str4;
                } catch (Throwable th8) {
                    e9 = th8;
                    fileInputStream = null;
                    inputStreamReader = null;
                    bufferedReader = null;
                    inputStream = drinkACupOfCoffeeForCamera;
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.o(49582);
                    throw e9;
                }
            }
            fileInputStream = null;
            inputStream = drinkACupOfCoffeeForCamera;
            if (inputStream == null) {
                try {
                    inputStreamReader2 = new InputStreamReader(inputStream);
                    try {
                        bufferedReader2 = new BufferedReader(inputStreamReader2, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                        try {
                            StringBuffer stringBuffer = new StringBuffer();
                            while (true) {
                                String readLine = bufferedReader2.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(readLine);
                            }
                            str4 = stringBuffer.toString();
                        } catch (Exception e11) {
                            e9 = e11;
                            inputStreamReader = inputStreamReader2;
                            bufferedReader = bufferedReader2;
                        } catch (Throwable th9) {
                            e9 = th9;
                            inputStreamReader = inputStreamReader2;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e12) {
                                    LogUtils.e(e12);
                                    AppMethodBeat.o(49582);
                                    throw e9;
                                }
                            }
                            if (inputStreamReader != null) {
                                inputStreamReader.close();
                            }
                            if (inputStream != null) {
                                inputStream.close();
                            }
                            if (fileInputStream != null) {
                                fileInputStream.close();
                            }
                            AppMethodBeat.o(49582);
                            throw e9;
                        }
                    } catch (Exception e13) {
                        e9 = e13;
                        inputStreamReader = inputStreamReader2;
                        bufferedReader = null;
                        LogUtils.e(e9);
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        str4 = null;
                        AppMethodBeat.o(49582);
                        return str4;
                    } catch (Throwable th10) {
                        e9 = th10;
                        inputStreamReader = inputStreamReader2;
                        bufferedReader = null;
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (fileInputStream != null) {
                        }
                        AppMethodBeat.o(49582);
                        throw e9;
                    }
                } catch (Exception e14) {
                    e9 = e14;
                    inputStreamReader = null;
                    bufferedReader = null;
                    LogUtils.e(e9);
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    str4 = null;
                    AppMethodBeat.o(49582);
                    return str4;
                } catch (Throwable th11) {
                    e9 = th11;
                    inputStreamReader = null;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (fileInputStream != null) {
                    }
                    AppMethodBeat.o(49582);
                    throw e9;
                }
            }
            inputStreamReader2 = null;
            bufferedReader2 = null;
            str4 = null;
            if (bufferedReader2 != null) {
                try {
                    bufferedReader2.close();
                } catch (IOException e122) {
                    LogUtils.e(e122);
                }
            }
            if (inputStreamReader2 != null) {
                inputStreamReader2.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (Exception e15) {
            e9 = e15;
            fileInputStream = null;
            inputStreamReader = null;
            bufferedReader = null;
            inputStream = null;
            LogUtils.e(e9);
            if (bufferedReader != null) {
            }
            if (inputStreamReader != null) {
            }
            if (inputStream != null) {
            }
            if (fileInputStream != null) {
            }
            str4 = null;
            AppMethodBeat.o(49582);
            return str4;
        } catch (Throwable th12) {
            e9 = th12;
            fileInputStream = null;
            inputStreamReader = null;
            bufferedReader = null;
            inputStream = null;
            if (bufferedReader != null) {
            }
            if (inputStreamReader != null) {
            }
            if (inputStream != null) {
            }
            if (fileInputStream != null) {
            }
            AppMethodBeat.o(49582);
            throw e9;
        }
        AppMethodBeat.o(49582);
        return str4;
    }

    public static JSONObject parseFile(Context context, String str, String str2, boolean z) {
        AppMethodBeat.i(49583);
        JSONObject parseIOSFileProcess;
        if (z) {
            parseIOSFileProcess = parseIOSFileProcess(context, str, str2, false);
            AppMethodBeat.o(49583);
            return parseIOSFileProcess;
        }
        parseIOSFileProcess = parseFileProcess(context, str, str2, false);
        AppMethodBeat.o(49583);
        return parseIOSFileProcess;
    }

    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d2 A:{SYNTHETIC, Splitter:B:44:0x00d2} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d7 A:{Catch:{ IOException -> 0x019f }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00dc A:{Catch:{ IOException -> 0x019f }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e1 A:{Catch:{ IOException -> 0x019f }} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01ae A:{SYNTHETIC, Splitter:B:119:0x01ae} */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01b3 A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01b8 A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01bd A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d2 A:{SYNTHETIC, Splitter:B:44:0x00d2} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d7 A:{Catch:{ IOException -> 0x019f }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00dc A:{Catch:{ IOException -> 0x019f }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e1 A:{Catch:{ IOException -> 0x019f }} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01ae A:{SYNTHETIC, Splitter:B:119:0x01ae} */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01b3 A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01b8 A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01bd A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01ae A:{SYNTHETIC, Splitter:B:119:0x01ae} */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01b3 A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01b8 A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01bd A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d2 A:{SYNTHETIC, Splitter:B:44:0x00d2} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d7 A:{Catch:{ IOException -> 0x019f }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00dc A:{Catch:{ IOException -> 0x019f }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e1 A:{Catch:{ IOException -> 0x019f }} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01ae A:{SYNTHETIC, Splitter:B:119:0x01ae} */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01b3 A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01b8 A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01bd A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00af A:{SYNTHETIC, Splitter:B:29:0x00af} */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0180 A:{SYNTHETIC, Splitter:B:102:0x0180} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0185 A:{Catch:{ IOException -> 0x0194 }} */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x018a A:{Catch:{ IOException -> 0x0194 }} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x018f A:{Catch:{ IOException -> 0x0194 }} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d2 A:{SYNTHETIC, Splitter:B:44:0x00d2} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d7 A:{Catch:{ IOException -> 0x019f }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00dc A:{Catch:{ IOException -> 0x019f }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e1 A:{Catch:{ IOException -> 0x019f }} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01ae A:{SYNTHETIC, Splitter:B:119:0x01ae} */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01b3 A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01b8 A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01bd A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01ae A:{SYNTHETIC, Splitter:B:119:0x01ae} */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01b3 A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01b8 A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01bd A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00af A:{SYNTHETIC, Splitter:B:29:0x00af} */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0180 A:{SYNTHETIC, Splitter:B:102:0x0180} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0185 A:{Catch:{ IOException -> 0x0194 }} */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x018a A:{Catch:{ IOException -> 0x0194 }} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x018f A:{Catch:{ IOException -> 0x0194 }} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d2 A:{SYNTHETIC, Splitter:B:44:0x00d2} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d7 A:{Catch:{ IOException -> 0x019f }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00dc A:{Catch:{ IOException -> 0x019f }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e1 A:{Catch:{ IOException -> 0x019f }} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01ae A:{SYNTHETIC, Splitter:B:119:0x01ae} */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01b3 A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01b8 A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01bd A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00af A:{SYNTHETIC, Splitter:B:29:0x00af} */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0180 A:{SYNTHETIC, Splitter:B:102:0x0180} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0185 A:{Catch:{ IOException -> 0x0194 }} */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x018a A:{Catch:{ IOException -> 0x0194 }} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x018f A:{Catch:{ IOException -> 0x0194 }} */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x014b  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x013c A:{Catch:{ IOException -> 0x0150, Exception -> 0x020b, all -> 0x01d6 }} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x014d  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x013f A:{Catch:{ IOException -> 0x0150, Exception -> 0x020b, all -> 0x01d6 }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00af A:{SYNTHETIC, Splitter:B:29:0x00af} */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0230  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0180 A:{SYNTHETIC, Splitter:B:102:0x0180} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0185 A:{Catch:{ IOException -> 0x0194 }} */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x018a A:{Catch:{ IOException -> 0x0194 }} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x018f A:{Catch:{ IOException -> 0x0194 }} */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x020b A:{Splitter:B:73:0x0127, ExcHandler: Exception (e java.lang.Exception)} */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01d6 A:{Splitter:B:73:0x0127, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01ae A:{SYNTHETIC, Splitter:B:119:0x01ae} */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01b3 A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01b8 A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01bd A:{Catch:{ IOException -> 0x01c4 }} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:90:0x0150, code skipped:
            r1 = e;
     */
    /* JADX WARNING: Missing block: B:91:0x0151, code skipped:
            r2 = r0;
     */
    /* JADX WARNING: Missing block: B:135:0x01d6, code skipped:
            r1 = th;
     */
    /* JADX WARNING: Missing block: B:136:0x01d7, code skipped:
            r4 = null;
            r5 = null;
            r6 = null;
            r7 = r0;
     */
    /* JADX WARNING: Missing block: B:153:0x020b, code skipped:
            r1 = e;
     */
    /* JADX WARNING: Missing block: B:154:0x020c, code skipped:
            r4 = null;
            r5 = null;
            r6 = null;
            r7 = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static JSONObject parseFileProcess(Context context, String str, String str2, boolean z) {
        InputStream inputStream;
        FileInputStream fileInputStream;
        Throwable e;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        JSONObject jSONObject;
        InputStreamReader inputStreamReader2;
        AppMethodBeat.i(49584);
        String str3 = str + "/" + str2 + "." + (z ? POSTFIX_ORIG : "dat");
        String str4 = str + "/" + str2 + "." + (!z ? POSTFIX_ORIG : "dat");
        LogUtils.v("ContentValues", "parseFile(), full path = %s", str3);
        try {
            File file = new File(str3);
            File file2 = new File(str4);
            InputStream fileInputStream2;
            if ((file.exists() && file.isFile()) || (file2.exists() && file2.isFile())) {
                LogUtils.v("ContentValues", "parseFile file exists and isFile");
                if (file.exists() && file.isFile()) {
                    fileInputStream2 = new FileInputStream(file);
                } else if (file2.exists() && file2.isFile()) {
                    fileInputStream2 = new FileInputStream(file2);
                    z = !z;
                } else {
                    fileInputStream2 = null;
                }
                InputStream fileInputStream3;
                if (z) {
                    fileInputStream3 = fileInputStream2;
                    inputStream = fileInputStream2;
                } else {
                    try {
                        inputStream = drinkACupOfCoffee(fileInputStream2, false);
                        try {
                            IOUtils.closeQuietly(fileInputStream2);
                            fileInputStream3 = fileInputStream2;
                        } catch (Exception e2) {
                            e = e2;
                            fileInputStream3 = fileInputStream2;
                            inputStreamReader = null;
                            bufferedReader = null;
                            LogUtils.e(e);
                            if (bufferedReader != null) {
                            }
                            if (inputStreamReader != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (fileInputStream3 != null) {
                            }
                            jSONObject = null;
                            AppMethodBeat.o(49584);
                            return jSONObject;
                        } catch (Throwable e22) {
                            e = e22;
                            fileInputStream3 = fileInputStream2;
                            inputStreamReader = null;
                            bufferedReader = null;
                            if (bufferedReader != null) {
                            }
                            if (inputStreamReader != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (fileInputStream3 != null) {
                            }
                            AppMethodBeat.o(49584);
                            throw e;
                        }
                    } catch (Exception e222) {
                        e = e222;
                        fileInputStream3 = fileInputStream2;
                        inputStreamReader = null;
                        bufferedReader = null;
                        inputStream = null;
                    } catch (Throwable e2222) {
                        e = e2222;
                        fileInputStream3 = fileInputStream2;
                        inputStreamReader = null;
                        bufferedReader = null;
                        inputStream = null;
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (fileInputStream3 != null) {
                        }
                        AppMethodBeat.o(49584);
                        throw e;
                    }
                }
            }
            LogUtils.v("ContentValues", "parseFile file is in Assets directory");
            InputStream drinkACupOfCoffee;
            try {
                inputStream = context.getAssets().open(str3);
                if (z) {
                    fileInputStream3 = null;
                } else {
                    drinkACupOfCoffee = drinkACupOfCoffee(inputStream, false);
                    try {
                        IOUtils.closeQuietly(inputStream);
                        fileInputStream3 = null;
                        inputStream = drinkACupOfCoffee;
                    } catch (IOException e3) {
                        inputStream = context.getAssets().open(str4);
                        if (z) {
                        }
                        if (z) {
                        }
                        if (inputStream != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader2 != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (fileInputStream3 != null) {
                        }
                        AppMethodBeat.o(49584);
                        return jSONObject;
                    } catch (Exception e4) {
                    } catch (Throwable th) {
                    }
                }
            } catch (IOException e5) {
                drinkACupOfCoffee = null;
                inputStream = context.getAssets().open(str4);
                if (z) {
                    z = true;
                } else {
                    z = false;
                }
                if (z) {
                    fileInputStream2 = drinkACupOfCoffee(inputStream, false);
                    try {
                        IOUtils.closeQuietly(inputStream);
                        fileInputStream3 = null;
                        inputStream = fileInputStream2;
                    } catch (IOException e22222) {
                        e = e22222;
                        try {
                            LogUtils.e(e);
                            fileInputStream3 = null;
                            inputStream = fileInputStream2;
                            if (inputStream != null) {
                            }
                            if (bufferedReader != null) {
                            }
                            if (inputStreamReader2 != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (fileInputStream3 != null) {
                            }
                        } catch (Exception e222222) {
                            e = e222222;
                            fileInputStream3 = null;
                            inputStreamReader = null;
                            bufferedReader = null;
                            inputStream = fileInputStream2;
                            try {
                                LogUtils.e(e);
                                if (bufferedReader != null) {
                                }
                                if (inputStreamReader != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (fileInputStream3 != null) {
                                }
                                jSONObject = null;
                                AppMethodBeat.o(49584);
                                return jSONObject;
                            } catch (Throwable e2222222) {
                                e = e2222222;
                                if (bufferedReader != null) {
                                }
                                if (inputStreamReader != null) {
                                }
                                if (inputStream != null) {
                                }
                                if (fileInputStream3 != null) {
                                }
                                AppMethodBeat.o(49584);
                                throw e;
                            }
                        } catch (Throwable e22222222) {
                            e = e22222222;
                            fileInputStream3 = null;
                            inputStreamReader = null;
                            bufferedReader = null;
                            inputStream = fileInputStream2;
                            if (bufferedReader != null) {
                            }
                            if (inputStreamReader != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (fileInputStream3 != null) {
                            }
                            AppMethodBeat.o(49584);
                            throw e;
                        }
                        AppMethodBeat.o(49584);
                        return jSONObject;
                    }
                }
                fileInputStream3 = null;
                if (inputStream != null) {
                }
                if (bufferedReader != null) {
                }
                if (inputStreamReader2 != null) {
                }
                if (inputStream != null) {
                }
                if (fileInputStream3 != null) {
                }
                AppMethodBeat.o(49584);
                return jSONObject;
            }
            if (inputStream != null) {
                try {
                    inputStreamReader2 = new InputStreamReader(inputStream);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader2, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                        try {
                            String jSONObject2;
                            StringBuffer stringBuffer = new StringBuffer();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(readLine);
                            }
                            if (z) {
                                jSONObject2 = XML.toJSONObject(stringBuffer.toString()).toString();
                            } else {
                                jSONObject2 = stringBuffer.toString();
                            }
                            LogUtils.d("ContentValues", jSONObject2);
                            jSONObject = !TextUtils.isEmpty(jSONObject2) ? (JSONObject) new JSONTokener(jSONObject2).nextValue() : null;
                        } catch (Exception e222222222) {
                            e = e222222222;
                            inputStreamReader = inputStreamReader2;
                        } catch (Throwable e2222222222) {
                            e = e2222222222;
                            inputStreamReader = inputStreamReader2;
                            if (bufferedReader != null) {
                            }
                            if (inputStreamReader != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (fileInputStream3 != null) {
                            }
                            AppMethodBeat.o(49584);
                            throw e;
                        }
                    } catch (Exception e22222222222) {
                        e = e22222222222;
                        inputStreamReader = inputStreamReader2;
                        bufferedReader = null;
                        LogUtils.e(e);
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (fileInputStream3 != null) {
                        }
                        jSONObject = null;
                        AppMethodBeat.o(49584);
                        return jSONObject;
                    } catch (Throwable e222222222222) {
                        e = e222222222222;
                        inputStreamReader = inputStreamReader2;
                        bufferedReader = null;
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (fileInputStream3 != null) {
                        }
                        AppMethodBeat.o(49584);
                        throw e;
                    }
                } catch (Exception e2222222222222) {
                    e = e2222222222222;
                    inputStreamReader = null;
                    bufferedReader = null;
                    LogUtils.e(e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                            LogUtils.e(e6);
                            jSONObject = null;
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileInputStream3 != null) {
                        fileInputStream3.close();
                    }
                    jSONObject = null;
                    AppMethodBeat.o(49584);
                    return jSONObject;
                } catch (Throwable e22222222222222) {
                    e = e22222222222222;
                    inputStreamReader = null;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e62) {
                            LogUtils.e(e62);
                            AppMethodBeat.o(49584);
                            throw e;
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileInputStream3 != null) {
                        fileInputStream3.close();
                    }
                    AppMethodBeat.o(49584);
                    throw e;
                }
            }
            inputStreamReader2 = null;
            bufferedReader = null;
            jSONObject = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e7) {
                    LogUtils.e(e7);
                }
            }
            if (inputStreamReader2 != null) {
                inputStreamReader2.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileInputStream3 != null) {
                fileInputStream3.close();
            }
        } catch (Exception e222222222222222) {
            e = e222222222222222;
            fileInputStream3 = null;
            inputStreamReader = null;
            bufferedReader = null;
            inputStream = null;
            LogUtils.e(e);
            if (bufferedReader != null) {
            }
            if (inputStreamReader != null) {
            }
            if (inputStream != null) {
            }
            if (fileInputStream3 != null) {
            }
            jSONObject = null;
            AppMethodBeat.o(49584);
            return jSONObject;
        } catch (Throwable e2222222222222222) {
            e = e2222222222222222;
            fileInputStream3 = null;
            inputStreamReader = null;
            bufferedReader = null;
            inputStream = null;
            if (bufferedReader != null) {
            }
            if (inputStreamReader != null) {
            }
            if (inputStream != null) {
            }
            if (fileInputStream3 != null) {
            }
            AppMethodBeat.o(49584);
            throw e;
        }
        AppMethodBeat.o(49584);
        return jSONObject;
    }

    /* JADX WARNING: Removed duplicated region for block: B:165:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{SYNTHETIC, Splitter:B:29:0x00a2} */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0173 A:{SYNTHETIC, Splitter:B:102:0x0173} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0178 A:{Catch:{ IOException -> 0x0187 }} */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x017d A:{Catch:{ IOException -> 0x0187 }} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0182 A:{Catch:{ IOException -> 0x0187 }} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01a1 A:{SYNTHETIC, Splitter:B:119:0x01a1} */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01a6 A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01ab A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01b0 A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c5 A:{SYNTHETIC, Splitter:B:44:0x00c5} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ca A:{Catch:{ IOException -> 0x0192 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cf A:{Catch:{ IOException -> 0x0192 }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d4 A:{Catch:{ IOException -> 0x0192 }} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01a1 A:{SYNTHETIC, Splitter:B:119:0x01a1} */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01a6 A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01ab A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01b0 A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{SYNTHETIC, Splitter:B:29:0x00a2} */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0173 A:{SYNTHETIC, Splitter:B:102:0x0173} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0178 A:{Catch:{ IOException -> 0x0187 }} */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x017d A:{Catch:{ IOException -> 0x0187 }} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0182 A:{Catch:{ IOException -> 0x0187 }} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c5 A:{SYNTHETIC, Splitter:B:44:0x00c5} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ca A:{Catch:{ IOException -> 0x0192 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cf A:{Catch:{ IOException -> 0x0192 }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d4 A:{Catch:{ IOException -> 0x0192 }} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01a1 A:{SYNTHETIC, Splitter:B:119:0x01a1} */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01a6 A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01ab A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01b0 A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c5 A:{SYNTHETIC, Splitter:B:44:0x00c5} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ca A:{Catch:{ IOException -> 0x0192 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cf A:{Catch:{ IOException -> 0x0192 }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d4 A:{Catch:{ IOException -> 0x0192 }} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01a1 A:{SYNTHETIC, Splitter:B:119:0x01a1} */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01a6 A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01ab A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01b0 A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01a1 A:{SYNTHETIC, Splitter:B:119:0x01a1} */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01a6 A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01ab A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01b0 A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{SYNTHETIC, Splitter:B:29:0x00a2} */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0173 A:{SYNTHETIC, Splitter:B:102:0x0173} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0178 A:{Catch:{ IOException -> 0x0187 }} */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x017d A:{Catch:{ IOException -> 0x0187 }} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0182 A:{Catch:{ IOException -> 0x0187 }} */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x01fe A:{Splitter:B:73:0x011a, ExcHandler: Exception (e java.lang.Exception)} */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x01c9 A:{Splitter:B:73:0x011a, ExcHandler: all (th java.lang.Throwable)} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c5 A:{SYNTHETIC, Splitter:B:44:0x00c5} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ca A:{Catch:{ IOException -> 0x0192 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cf A:{Catch:{ IOException -> 0x0192 }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d4 A:{Catch:{ IOException -> 0x0192 }} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01a1 A:{SYNTHETIC, Splitter:B:119:0x01a1} */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01a6 A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01ab A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01b0 A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00c5 A:{SYNTHETIC, Splitter:B:44:0x00c5} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ca A:{Catch:{ IOException -> 0x0192 }} */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00cf A:{Catch:{ IOException -> 0x0192 }} */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d4 A:{Catch:{ IOException -> 0x0192 }} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01a1 A:{SYNTHETIC, Splitter:B:119:0x01a1} */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01a6 A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01ab A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01b0 A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x013e  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x012f A:{Catch:{ IOException -> 0x0143, Exception -> 0x01fe, all -> 0x01c9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x0132 A:{Catch:{ IOException -> 0x0143, Exception -> 0x01fe, all -> 0x01c9 }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A:{SYNTHETIC, Splitter:B:29:0x00a2} */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0223  */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x0173 A:{SYNTHETIC, Splitter:B:102:0x0173} */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0178 A:{Catch:{ IOException -> 0x0187 }} */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x017d A:{Catch:{ IOException -> 0x0187 }} */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0182 A:{Catch:{ IOException -> 0x0187 }} */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x01a1 A:{SYNTHETIC, Splitter:B:119:0x01a1} */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x01a6 A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:124:0x01ab A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x01b0 A:{Catch:{ IOException -> 0x01b7 }} */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing block: B:90:0x0143, code skipped:
            r1 = e;
     */
    /* JADX WARNING: Missing block: B:91:0x0144, code skipped:
            r2 = r0;
     */
    /* JADX WARNING: Missing block: B:135:0x01c9, code skipped:
            r1 = th;
     */
    /* JADX WARNING: Missing block: B:136:0x01ca, code skipped:
            r4 = null;
            r5 = null;
            r6 = null;
            r7 = r0;
     */
    /* JADX WARNING: Missing block: B:153:0x01fe, code skipped:
            r1 = e;
     */
    /* JADX WARNING: Missing block: B:154:0x01ff, code skipped:
            r4 = null;
            r5 = null;
            r6 = null;
            r7 = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static JSONObject parseIOSFileProcess(Context context, String str, String str2, boolean z) {
        InputStream inputStream;
        FileInputStream fileInputStream;
        Throwable e;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        JSONObject jSONObject;
        InputStreamReader inputStreamReader2;
        AppMethodBeat.i(49585);
        String str3 = str + "/" + str2 + "." + (z ? POSTFIX_ORIG : POSTFIX_WMC);
        String str4 = str + "/" + str2 + "." + (!z ? POSTFIX_ORIG : POSTFIX_WMC);
        try {
            File file = new File(str3);
            File file2 = new File(str4);
            InputStream fileInputStream2;
            if ((file.exists() && file.isFile()) || (file2.exists() && file2.isFile())) {
                LogUtils.v("ContentValues", "parseFile file exists and isFile");
                if (file.exists() && file.isFile()) {
                    fileInputStream2 = new FileInputStream(file);
                } else if (file2.exists() && file2.isFile()) {
                    fileInputStream2 = new FileInputStream(file2);
                    z = !z;
                } else {
                    fileInputStream2 = null;
                }
                InputStream fileInputStream3;
                if (z) {
                    fileInputStream3 = fileInputStream2;
                    inputStream = fileInputStream2;
                } else {
                    try {
                        inputStream = drinkACupOfCoffee(fileInputStream2, true);
                        try {
                            IOUtils.closeQuietly(fileInputStream2);
                            fileInputStream3 = fileInputStream2;
                        } catch (Exception e2) {
                            e = e2;
                            fileInputStream3 = fileInputStream2;
                            inputStreamReader = null;
                            bufferedReader = null;
                            LogUtils.e(e);
                            if (bufferedReader != null) {
                            }
                            if (inputStreamReader != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (fileInputStream3 != null) {
                            }
                            jSONObject = null;
                            AppMethodBeat.o(49585);
                            return jSONObject;
                        } catch (Throwable e22) {
                            e = e22;
                            fileInputStream3 = fileInputStream2;
                            inputStreamReader = null;
                            bufferedReader = null;
                            if (bufferedReader != null) {
                            }
                            if (inputStreamReader != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (fileInputStream3 != null) {
                            }
                            AppMethodBeat.o(49585);
                            throw e;
                        }
                    } catch (Exception e222) {
                        e = e222;
                        fileInputStream3 = fileInputStream2;
                        inputStreamReader = null;
                        bufferedReader = null;
                        inputStream = null;
                    } catch (Throwable e2222) {
                        e = e2222;
                        fileInputStream3 = fileInputStream2;
                        inputStreamReader = null;
                        bufferedReader = null;
                        inputStream = null;
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (fileInputStream3 != null) {
                        }
                        AppMethodBeat.o(49585);
                        throw e;
                    }
                }
            }
            LogUtils.v("ContentValues", "parseFile file is in Assets directory");
            InputStream drinkACupOfCoffee;
            try {
                inputStream = context.getAssets().open(str3);
                if (z) {
                    fileInputStream3 = null;
                } else {
                    drinkACupOfCoffee = drinkACupOfCoffee(inputStream, true);
                    try {
                        IOUtils.closeQuietly(inputStream);
                        fileInputStream3 = null;
                        inputStream = drinkACupOfCoffee;
                    } catch (IOException e3) {
                        inputStream = context.getAssets().open(str4);
                        if (z) {
                            z = true;
                        } else {
                            z = false;
                        }
                        if (z) {
                            fileInputStream2 = drinkACupOfCoffee(inputStream, true);
                            try {
                                IOUtils.closeQuietly(inputStream);
                                fileInputStream3 = null;
                                inputStream = fileInputStream2;
                            } catch (IOException e22222) {
                                e = e22222;
                                try {
                                    LogUtils.e(e);
                                    fileInputStream3 = null;
                                    inputStream = fileInputStream2;
                                    if (inputStream != null) {
                                    }
                                    if (bufferedReader != null) {
                                    }
                                    if (inputStreamReader2 != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (fileInputStream3 != null) {
                                    }
                                } catch (Exception e222222) {
                                    e = e222222;
                                    fileInputStream3 = null;
                                    inputStreamReader = null;
                                    bufferedReader = null;
                                    inputStream = fileInputStream2;
                                    try {
                                        LogUtils.e(e);
                                        if (bufferedReader != null) {
                                        }
                                        if (inputStreamReader != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        if (fileInputStream3 != null) {
                                        }
                                        jSONObject = null;
                                        AppMethodBeat.o(49585);
                                        return jSONObject;
                                    } catch (Throwable e2222222) {
                                        e = e2222222;
                                        if (bufferedReader != null) {
                                            try {
                                                bufferedReader.close();
                                            } catch (IOException e4) {
                                                LogUtils.e(e4);
                                                AppMethodBeat.o(49585);
                                                throw e;
                                            }
                                        }
                                        if (inputStreamReader != null) {
                                            inputStreamReader.close();
                                        }
                                        if (inputStream != null) {
                                            inputStream.close();
                                        }
                                        if (fileInputStream3 != null) {
                                            fileInputStream3.close();
                                        }
                                        AppMethodBeat.o(49585);
                                        throw e;
                                    }
                                } catch (Throwable e22222222) {
                                    e = e22222222;
                                    fileInputStream3 = null;
                                    inputStreamReader = null;
                                    bufferedReader = null;
                                    inputStream = fileInputStream2;
                                    if (bufferedReader != null) {
                                    }
                                    if (inputStreamReader != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    if (fileInputStream3 != null) {
                                    }
                                    AppMethodBeat.o(49585);
                                    throw e;
                                }
                                AppMethodBeat.o(49585);
                                return jSONObject;
                            }
                        }
                        fileInputStream3 = null;
                        if (inputStream != null) {
                        }
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader2 != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (fileInputStream3 != null) {
                        }
                        AppMethodBeat.o(49585);
                        return jSONObject;
                    } catch (Exception e5) {
                    } catch (Throwable th) {
                    }
                }
            } catch (IOException e6) {
                drinkACupOfCoffee = null;
                inputStream = context.getAssets().open(str4);
                if (z) {
                }
                if (z) {
                }
                if (inputStream != null) {
                }
                if (bufferedReader != null) {
                }
                if (inputStreamReader2 != null) {
                }
                if (inputStream != null) {
                }
                if (fileInputStream3 != null) {
                }
                AppMethodBeat.o(49585);
                return jSONObject;
            }
            if (inputStream != null) {
                try {
                    inputStreamReader2 = new InputStreamReader(inputStream);
                    try {
                        bufferedReader = new BufferedReader(inputStreamReader2, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                        try {
                            String jSONObject2;
                            StringBuffer stringBuffer = new StringBuffer();
                            while (true) {
                                String readLine = bufferedReader.readLine();
                                if (readLine == null) {
                                    break;
                                }
                                stringBuffer.append(readLine);
                            }
                            if (z) {
                                jSONObject2 = XML.toJSONObject(stringBuffer.toString()).toString();
                            } else {
                                jSONObject2 = stringBuffer.toString();
                            }
                            LogUtils.d("ContentValues", jSONObject2);
                            jSONObject = !TextUtils.isEmpty(jSONObject2) ? (JSONObject) new JSONTokener(jSONObject2).nextValue() : null;
                        } catch (Exception e222222222) {
                            e = e222222222;
                            inputStreamReader = inputStreamReader2;
                        } catch (Throwable e2222222222) {
                            e = e2222222222;
                            inputStreamReader = inputStreamReader2;
                            if (bufferedReader != null) {
                            }
                            if (inputStreamReader != null) {
                            }
                            if (inputStream != null) {
                            }
                            if (fileInputStream3 != null) {
                            }
                            AppMethodBeat.o(49585);
                            throw e;
                        }
                    } catch (Exception e22222222222) {
                        e = e22222222222;
                        inputStreamReader = inputStreamReader2;
                        bufferedReader = null;
                        LogUtils.e(e);
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (fileInputStream3 != null) {
                        }
                        jSONObject = null;
                        AppMethodBeat.o(49585);
                        return jSONObject;
                    } catch (Throwable e222222222222) {
                        e = e222222222222;
                        inputStreamReader = inputStreamReader2;
                        bufferedReader = null;
                        if (bufferedReader != null) {
                        }
                        if (inputStreamReader != null) {
                        }
                        if (inputStream != null) {
                        }
                        if (fileInputStream3 != null) {
                        }
                        AppMethodBeat.o(49585);
                        throw e;
                    }
                } catch (Exception e2222222222222) {
                    e = e2222222222222;
                    inputStreamReader = null;
                    bufferedReader = null;
                    LogUtils.e(e);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e42) {
                            LogUtils.e(e42);
                            jSONObject = null;
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    if (fileInputStream3 != null) {
                        fileInputStream3.close();
                    }
                    jSONObject = null;
                    AppMethodBeat.o(49585);
                    return jSONObject;
                } catch (Throwable e22222222222222) {
                    e = e22222222222222;
                    inputStreamReader = null;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    if (fileInputStream3 != null) {
                    }
                    AppMethodBeat.o(49585);
                    throw e;
                }
            }
            inputStreamReader2 = null;
            bufferedReader = null;
            jSONObject = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e7) {
                    LogUtils.e(e7);
                }
            }
            if (inputStreamReader2 != null) {
                inputStreamReader2.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileInputStream3 != null) {
                fileInputStream3.close();
            }
        } catch (Exception e222222222222222) {
            e = e222222222222222;
            fileInputStream3 = null;
            inputStreamReader = null;
            bufferedReader = null;
            inputStream = null;
            LogUtils.e(e);
            if (bufferedReader != null) {
            }
            if (inputStreamReader != null) {
            }
            if (inputStream != null) {
            }
            if (fileInputStream3 != null) {
            }
            jSONObject = null;
            AppMethodBeat.o(49585);
            return jSONObject;
        } catch (Throwable e2222222222222222) {
            e = e2222222222222222;
            fileInputStream3 = null;
            inputStreamReader = null;
            bufferedReader = null;
            inputStream = null;
            if (bufferedReader != null) {
            }
            if (inputStreamReader != null) {
            }
            if (inputStream != null) {
            }
            if (fileInputStream3 != null) {
            }
            AppMethodBeat.o(49585);
            throw e;
        }
        AppMethodBeat.o(49585);
        return jSONObject;
    }

    private static InputStream drinkACupOfCoffee(InputStream inputStream, boolean z) {
        AppMethodBeat.i(49586);
        byte[] toByteArray = IOUtils.toByteArray(inputStream);
        if (z) {
            toByteArray = Coffee.drink_ios(toByteArray, Coffee.getDefaultSign());
        } else {
            toByteArray = Coffee.drink(toByteArray, Coffee.getDefaultSign());
        }
        InputStream toInputStream = IOUtils.toInputStream(toByteArray);
        AppMethodBeat.o(49586);
        return toInputStream;
    }

    private static int RGBAStr2Int(String str, String str2, String str3, String str4) {
        int i = 1;
        AppMethodBeat.i(49587);
        if (TextUtils.isEmpty(str4) || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            AppMethodBeat.o(49587);
            return 0;
        }
        int parseInt = Integer.parseInt(str4);
        int parseInt2 = Integer.parseInt(str);
        int parseInt3 = Integer.parseInt(str2);
        int parseInt4 = Integer.parseInt(str3);
        if (parseInt2 == 0) {
            parseInt2 = 1;
        }
        if (parseInt3 == 0) {
            parseInt3 = 1;
        }
        if (parseInt4 != 0) {
            i = parseInt4;
        }
        i = Color.argb(parseInt, parseInt2, parseInt3, i);
        AppMethodBeat.o(49587);
        return i;
    }

    private static InputStream drinkACupOfCoffeeForCamera(InputStream inputStream, String str, String str2) {
        AppMethodBeat.i(49588);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(DeviceCoffee.drink(IOUtils.toByteArray(inputStream), str, str2));
        AppMethodBeat.o(49588);
        return byteArrayInputStream;
    }

    /* JADX WARNING: Removed duplicated region for block: B:101:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003a A:{Catch:{ Exception -> 0x0088, all -> 0x00c7 }} */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0092 A:{SYNTHETIC, Splitter:B:56:0x0092} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0097 A:{Catch:{ IOException -> 0x00a0 }} */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x009c A:{Catch:{ IOException -> 0x00a0 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x007e A:{SYNTHETIC, Splitter:B:47:0x007e} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00b1 A:{SYNTHETIC, Splitter:B:69:0x00b1} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00b6 A:{Catch:{ IOException -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00bb A:{Catch:{ IOException -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005c A:{SYNTHETIC, Splitter:B:29:0x005c} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0061 A:{Catch:{ IOException -> 0x00a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066 A:{Catch:{ IOException -> 0x00a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00b1 A:{SYNTHETIC, Splitter:B:69:0x00b1} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00b6 A:{Catch:{ IOException -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00bb A:{Catch:{ IOException -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00b1 A:{SYNTHETIC, Splitter:B:69:0x00b1} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00b6 A:{Catch:{ IOException -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00bb A:{Catch:{ IOException -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005c A:{SYNTHETIC, Splitter:B:29:0x005c} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0061 A:{Catch:{ IOException -> 0x00a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066 A:{Catch:{ IOException -> 0x00a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00b1 A:{SYNTHETIC, Splitter:B:69:0x00b1} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00b6 A:{Catch:{ IOException -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00bb A:{Catch:{ IOException -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x007e A:{SYNTHETIC, Splitter:B:47:0x007e} */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x005c A:{SYNTHETIC, Splitter:B:29:0x005c} */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0061 A:{Catch:{ IOException -> 0x00a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0066 A:{Catch:{ IOException -> 0x00a5 }} */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x00b1 A:{SYNTHETIC, Splitter:B:69:0x00b1} */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x00b6 A:{Catch:{ IOException -> 0x00c2 }} */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x00bb A:{Catch:{ IOException -> 0x00c2 }} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String parseFastCaptureFile(Context context, String str, String str2) {
        InputStream inputStream;
        Throwable e;
        InputStreamReader inputStreamReader;
        BufferedReader bufferedReader;
        String str3;
        InputStreamReader inputStreamReader2;
        Throwable th;
        InputStream inputStream2;
        AppMethodBeat.i(49589);
        LogUtils.v("ContentValues", "[parseFastCaptureFile] filePath = ".concat(String.valueOf(str)));
        try {
            InputStream open;
            LogUtils.v("ContentValues", "[parseFastCaptureFile] parseFile file is in Assets directory");
            if (context != null) {
                InputStream drinkACupOfCoffeeForFast;
                try {
                    open = context.getAssets().open(str);
                    try {
                        drinkACupOfCoffeeForFast = drinkACupOfCoffeeForFast(open, str2);
                        try {
                            IOUtils.closeQuietly(open);
                            inputStream = drinkACupOfCoffeeForFast;
                        } catch (IOException e2) {
                            if (open != null) {
                                try {
                                    open.close();
                                    inputStream = drinkACupOfCoffeeForFast;
                                } catch (Exception e3) {
                                    e = e3;
                                    inputStreamReader = null;
                                    bufferedReader = null;
                                    inputStream = drinkACupOfCoffeeForFast;
                                    try {
                                        LogUtils.e(e);
                                        if (bufferedReader != null) {
                                        }
                                        if (inputStreamReader != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        str3 = null;
                                        AppMethodBeat.o(49589);
                                        return str3;
                                    } catch (Throwable th2) {
                                        e = th2;
                                        if (bufferedReader != null) {
                                        }
                                        if (inputStreamReader != null) {
                                        }
                                        if (inputStream != null) {
                                        }
                                        AppMethodBeat.o(49589);
                                        throw e;
                                    }
                                } catch (Throwable th3) {
                                    e = th3;
                                    inputStreamReader = null;
                                    bufferedReader = null;
                                    inputStream = drinkACupOfCoffeeForFast;
                                    if (bufferedReader != null) {
                                    }
                                    if (inputStreamReader != null) {
                                    }
                                    if (inputStream != null) {
                                    }
                                    AppMethodBeat.o(49589);
                                    throw e;
                                }
                            }
                            inputStream = drinkACupOfCoffeeForFast;
                            if (inputStream == null) {
                            }
                            if (bufferedReader != null) {
                            }
                            if (inputStreamReader2 != null) {
                            }
                            if (inputStream != null) {
                            }
                            AppMethodBeat.o(49589);
                            return str3;
                        } catch (Throwable th4) {
                            th = th4;
                            inputStream2 = open;
                            inputStream = drinkACupOfCoffeeForFast;
                            if (inputStream2 != null) {
                            }
                            AppMethodBeat.o(49589);
                            throw th;
                        }
                    } catch (IOException e4) {
                        drinkACupOfCoffeeForFast = null;
                    } catch (Throwable th5) {
                        th = th5;
                        inputStream2 = open;
                        inputStream = null;
                        if (inputStream2 != null) {
                            inputStream2.close();
                        }
                        AppMethodBeat.o(49589);
                        throw th;
                    }
                } catch (IOException e5) {
                    open = null;
                    drinkACupOfCoffeeForFast = null;
                } catch (Throwable e6) {
                    th = e6;
                    inputStream2 = null;
                    inputStream = null;
                    if (inputStream2 != null) {
                    }
                    AppMethodBeat.o(49589);
                    throw th;
                }
            }
            open = null;
            inputStream = null;
            if (open != null) {
                try {
                    open.close();
                } catch (Exception e7) {
                    e6 = e7;
                    inputStreamReader = null;
                    bufferedReader = null;
                    LogUtils.e(e6);
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    str3 = null;
                    AppMethodBeat.o(49589);
                    return str3;
                } catch (Throwable th6) {
                    e6 = th6;
                    inputStreamReader = null;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    AppMethodBeat.o(49589);
                    throw e6;
                }
            }
            if (inputStream == null) {
                inputStreamReader2 = new InputStreamReader(inputStream);
                try {
                    bufferedReader = new BufferedReader(inputStreamReader2, WXMediaMessage.DESCRIPTION_LENGTH_LIMIT);
                } catch (Exception e8) {
                    e6 = e8;
                    inputStreamReader = inputStreamReader2;
                    bufferedReader = null;
                    LogUtils.e(e6);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e9) {
                            LogUtils.e(e9);
                            str3 = null;
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    str3 = null;
                    AppMethodBeat.o(49589);
                    return str3;
                } catch (Throwable th7) {
                    e6 = th7;
                    inputStreamReader = inputStreamReader2;
                    bufferedReader = null;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e10) {
                            LogUtils.e(e10);
                            AppMethodBeat.o(49589);
                            throw e6;
                        }
                    }
                    if (inputStreamReader != null) {
                        inputStreamReader.close();
                    }
                    if (inputStream != null) {
                        inputStream.close();
                    }
                    AppMethodBeat.o(49589);
                    throw e6;
                }
                try {
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            break;
                        }
                        stringBuffer.append(readLine);
                    }
                    str3 = stringBuffer.toString();
                } catch (Exception e11) {
                    e6 = e11;
                    inputStreamReader = inputStreamReader2;
                } catch (Throwable th8) {
                    e6 = th8;
                    inputStreamReader = inputStreamReader2;
                    if (bufferedReader != null) {
                    }
                    if (inputStreamReader != null) {
                    }
                    if (inputStream != null) {
                    }
                    AppMethodBeat.o(49589);
                    throw e6;
                }
            }
            inputStreamReader2 = null;
            bufferedReader = null;
            str3 = null;
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e102) {
                    LogUtils.e(e102);
                }
            }
            if (inputStreamReader2 != null) {
                inputStreamReader2.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }
        } catch (Exception e12) {
            e6 = e12;
            inputStreamReader = null;
            bufferedReader = null;
            inputStream = null;
            LogUtils.e(e6);
            if (bufferedReader != null) {
            }
            if (inputStreamReader != null) {
            }
            if (inputStream != null) {
            }
            str3 = null;
            AppMethodBeat.o(49589);
            return str3;
        } catch (Throwable th9) {
            e6 = th9;
            inputStreamReader = null;
            bufferedReader = null;
            inputStream = null;
            if (bufferedReader != null) {
            }
            if (inputStreamReader != null) {
            }
            if (inputStream != null) {
            }
            AppMethodBeat.o(49589);
            throw e6;
        }
        AppMethodBeat.o(49589);
        return str3;
    }

    private static InputStream drinkACupOfCoffeeForFast(InputStream inputStream, String str) {
        AppMethodBeat.i(49590);
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(DeviceCoffee.drinkRawData(IOUtils.toByteArray(inputStream), str));
        AppMethodBeat.o(49590);
        return byteArrayInputStream;
    }
}
