#extension GL_OES_EGL_image_external : require

precision mediump float;


#if defined(DISPLAY_IMAGE)
uniform sampler2D u_diffuseTexture;//图片
#else
uniform samplerExternalOES u_diffuseTexture;//视频
//uniform sampler2D u_diffuseTextureY;//视频
//uniform sampler2D u_diffuseTextureUV;
#endif

vec4 _baseColor;
varying vec2 v_texCoord;

#if defined(GROUND_VEX)
varying vec2 v_texCoord_g[8];
#endif

uniform vec4 u_screenColor;//屏幕色
uniform int algorithmType;//选择算法类型
uniform int mode;//显示模式
uniform vec4 u_borderColor;//边缘颜色
uniform vec4 algorithmParam1;//算法参数
uniform vec4 algorithmParam2;//算法参数

uniform float currentTime;//当前时间，单位秒

vec3 rgb2hsv(vec4 rgb){
    float Cmax=max(rgb.r, max(rgb.g, rgb.b));
    float Cmin=min(rgb.r, min(rgb.g, rgb.b));
    float V=Cmax;
    if(Cmax == Cmin){
        return vec3(0.0, 0.0, V);//防除0
    }
    float S=(Cmax-Cmin)/Cmax;
    float H = 0.0;
    if (rgb.r == Cmax) H =(rgb.g-rgb.b)/(Cmax-Cmin)* 60.0;
    if (rgb.g == Cmax) H = 120.0+(rgb.b-rgb.r)/(Cmax-Cmin)* 60.0;
    if (rgb.b == Cmax) H = 240.0 +(rgb.r-rgb.g)/(Cmax-Cmin)* 60.0;
    if (H < 0.0) H = H + 360.0;
    H = H/360.0;
    return vec3(H, S, V);
}

vec3 hsv2rgb(vec3 hsv){
    float h = hsv.x;
    float s = hsv.y;
    float v = hsv.z;
    float R = 0.0;
    float G = 0.0;
    float B = 0.0;
    if (s <= 0.001){
        R=v;
        G=v;
        B=v;
    } else {
        h = h*6.0;
        float i = floor(h);
        float f = h - i;
        float a = v * ( 1.0 - s );
        float b = v * ( 1.0 - s * f );
        float c = v * ( 1.0 - s * (1.0 - f ) );
        if(i<=0.0){
            R = v;
            G = c;
            B = a;
        } else if(i<=1.0){
            R = b;
            G = v;
            B = a;
        } else if(i<=2.0){
            R = a;
            G = v;
            B = c;
        } else if(i<=3.0){
            R = a;
            G = b;
            B = v;
        } else if(i<=4.0){
            R = c;
            G = a;
            B = v;
        } else {
            R = v;
            G = a;
            B = b;
        }
    }
    return vec3(R, G, B);
}

float rgb2y (float r, float g, float b){
    /*a utility function to convert colors in RGB into YCbCr*/
    return 0.299*r + 0.587*g + 0.114*b;
    //return 0.257*r + 0.504*g + 0.098*b;
}

float rgb2cb(float r, float g, float b){
    /*a utility function to convert colors in RGB into YCbCr*/
    return 0.5 + -0.168736*r - 0.331264*g + 0.5*b;
    //return -0.148*r - 0.291*g + 0.439*b;
}

float rgb2cr(float r, float g, float b){
    /*a utility function to convert colors in RGB into YCbCr*/
    return 0.5 + 0.5*r - 0.418688*g - 0.081312*b;
    //return 0.439*r - 0.368*g - 0.071*b;
}
//对x进行剪切和缩放，小于low为0，大于high为1，其它平滑到0-1之间
float smoothclip(float low, float high, float x){
    if (x <= low){
        return 0.0;
    }
    if(x >= high){
        return 1.0;
    }
    return (x-low)/(high-low);
}

/*CbCr（UV）距离*/
vec4 greenscreen(vec4 color, float Cb_key,float Cr_key, float Cr_y, float tola,float tolb, float maskPow, float smoothL, float smoothH){
    float cb = rgb2cb(color.r,color.g,color.b);
    float cr = rgb2cr(color.r,color.g,color.b);
    float y = rgb2y(color.r,color.g,color.b);
    float mask = distance(vec2(cb, cr), vec2(Cb_key, Cr_key));
    mask = smoothclip(tola, tolb, mask);
    mask = 1.0 - mask;
    mask = pow(mask, maskPow);
    float r = max(gl_FragColor.r - mask*u_screenColor.r, 0.0);
    float g = max(gl_FragColor.g - mask*u_screenColor.g, 0.0);
    float b = max(gl_FragColor.b - mask*u_screenColor.b, 0.0);
    mask = 1.0-mask;
    if(mask < smoothL){
        mask = 0.0;
        r = g = b = 0.0;
    }
    if(mask > smoothH){
        mask = 1.0;
    }
    if(smoothH < 1.0){
        mask = mask/max(smoothH, 0.9);
    }
    return vec4(r,g,b, mask);
}

void main()
{
//#if defined(DISPLAY_IMAGE)
    _baseColor =  texture2D(u_diffuseTexture, v_texCoord);
    gl_FragColor.a = _baseColor.a;
    gl_FragColor.rgb = _baseColor.rgb;
//#else
//    vec3 yuv;
//    yuv.x = texture2D(u_diffuseTextureY, v_texCoord).r;//Y
//    vec2 uv = texture2D(u_diffuseTextureUV, v_texCoord).ra;//UV
//    yuv.y = uv.x-0.5;//YUV420sp NV21
//    yuv.z = uv.y-0.5;
//    gl_FragColor.a = 1.0;
//    gl_FragColor.rgb = mat3(1.0, 1.0, 1.0, 0.0, -0.34414, 1.772, 1.402, -0.71414, 0.0) * yuv;//yuv->rgb
//#endif
    if(mode == 4){//源
        return;
    }

    if(algorithmType == 0){//原ChromaKey算法
        float u_screenWeight = algorithmParam1.x;
        float u_balance = algorithmParam1.y;
        float u_clipBlack = algorithmParam1.z;
        float u_clipWhite = algorithmParam1.w;

        vec4 screenColor = u_screenColor;
        screenColor = u_borderColor;////适合用边缘色

        //screenColor 待优化，screenPrimary，screenSat应该在CPU中计算，对于每个像素都是一样的
        float screenFmin = min(min(screenColor.r, screenColor.g), screenColor.b);
        float screenFmax = max(max(screenColor.r, screenColor.g), screenColor.b);
        vec3 screenPrimary = step(screenFmax, screenColor.rgb);//RGB通道中值最大的被保留为1.0
        float secondaryComponents = dot(1.0 - screenPrimary, screenColor.rgb);//RGB除最大的另外两个通道被保留
        float screenSat = screenFmax - mix(secondaryComponents - screenFmin, secondaryComponents / 2.0, u_balance);//饱和度, HSB中的S

        //fragColor
        float fmin = min(min(gl_FragColor.r, gl_FragColor.g), gl_FragColor.b);
        float fmax = max(max(gl_FragColor.r, gl_FragColor.g), gl_FragColor.b);
        //	luminance = fmax
        vec3 pixelPrimary = step(fmax, gl_FragColor.rgb);
        secondaryComponents = dot(1.0 - pixelPrimary, gl_FragColor.rgb);
        float pixelSat = fmax - mix(secondaryComponents - fmin, secondaryComponents / 2.0, u_balance); // 饱和度, HSB中的S

        //如果颜色与背景色的主色不一样，认为它前景。solid=1.0代表alpha=1.0
        float diffPrimary = dot(abs(pixelPrimary - screenPrimary), vec3(1.0));
        float solid = step(1.0, step(pixelSat, 0.1) + step(fmax, 0.1) + diffPrimary);

        //半透明部分：如果主色一致，但饱和度小于背景色。其它的认为是背景部分。
        float alpha = max(0.0, 1.0 - pixelSat / screenSat);
        alpha = smoothclip(u_clipBlack, u_clipWhite, alpha);
        vec4 semiTransparentPixel = vec4((gl_FragColor.rgb - (1.0 - alpha) * screenColor.rgb * u_screenWeight), alpha);

        vec4 pixel = mix(semiTransparentPixel, gl_FragColor, solid);
        gl_FragColor = pixel;
    }
    else {
        if(algorithmType == 1) {//绿幕算法
            float u_maskClipLow = algorithmParam1.x;
            float u_maskClipHigh = algorithmParam1.y;
            float u_maskSmoothLow = algorithmParam1.z;
            float u_maskSmoothHigh = algorithmParam1.w;
            float u_maskPow = algorithmParam2.x;

            float cb_key = rgb2cb(u_screenColor.r,u_screenColor.g,u_screenColor.b);
            float cr_key = rgb2cr(u_screenColor.r,u_screenColor.g,u_screenColor.b);
            float cr_y = rgb2y(u_screenColor.r,u_screenColor.g,u_screenColor.b);
            gl_FragColor = greenscreen(gl_FragColor, cb_key, cr_key, cr_y, u_maskClipLow, u_maskClipHigh, u_maskPow, u_maskSmoothLow, u_maskSmoothHigh);
            //#if defined(GROUND_VEX) //边源平滑
            //            bool isBorder = false;
            //            if(gl_FragColor.a < 0.9 && gl_FragColor.a >= 0.01){
            //                isBorder = true;
            //            }
            //            if(isBorder){
            //                gl_FragColor /= 9.0;
            //                vec4 groundColor[8];
            //                for(int i=0; i<8; i++){
            //                    groundColor[i] =  texture2D(u_diffuseTexture, v_texCoord_g[i]);
            //                    groundColor[i] = greenscreen(groundColor[i], cb_key, cr_key, cr_y, u_maskClipLow, u_maskClipHigh, u_maskPow, u_maskSmoothLow, u_maskSmoothHigh);
            //                    gl_FragColor += groundColor[i]/9.0;
            //                }
            //            }
            //#endif
        } else {
            if(algorithmType == 2){//高质量ChromaKey算法
                float angle = 0.7854 + 0.7854*(max(0.0, min(0.95, algorithmParam1.x))*2.0-1.0);
                float param2 = (max(0.0, min(1.0, algorithmParam1.y))-0.5)*2.0;
                if(param2 > 0.0){
                    param2 = param2 * 5.0;
                }
                float noise_level = 0.0625 + 0.0625*param2;
                float smoothL = algorithmParam1.z;
                float smoothH = algorithmParam1.w;

                float key_Y = 0.257*u_screenColor.r + 0.504*u_screenColor.g + 0.098*u_screenColor.b;
                float key_Cb = -0.148*u_screenColor.r - 0.291*u_screenColor.g + 0.439*u_screenColor.b;
                float key_Cr = 0.439*u_screenColor.r - 0.368*u_screenColor.g - 0.071*u_screenColor.b;
                float kgl = sqrt(key_Cb*key_Cb + key_Cr*key_Cr);
                key_Cb = 0.5 * (key_Cb / kgl);//将key_Cb、key_Cr收缩到[-0.5,0.5]
                key_Cr = 0.5 * (key_Cr / kgl);

                float accept_angle_tg = min(tan(angle), 16.0);//tan值，防溢出，最大16
                float accept_angle_ctg = min(1.0/tan(angle), 16.0);//ctan值，最大16
                float one_over_kc = 2.0/kgl - 1.0;
                float kfgy_scale = min(key_Y/kgl, 16.0);
                float kg = min(kgl, 0.5);
                //上面一段可以主在cpu中，优化GPU重复执行问题

                //r g b = y cb cr
                float y = 0.257*gl_FragColor.r + 0.504*gl_FragColor.g + 0.098*gl_FragColor.b;
                float cb = -0.148*gl_FragColor.r - 0.291*gl_FragColor.g + 0.439*gl_FragColor.b;
                float cr = 0.439*gl_FragColor.r - 0.368*gl_FragColor.g - 0.071*gl_FragColor.b;

                //(cr, cb)旋转θ角得到(x, z). key_Cb对应cosθ, key_Cr对应sinθ
                float x = (cb*key_Cb + cr*key_Cr)/0.5;
                x = max(min(x, 0.5), -0.5);
                float z = (cr*key_Cb - cb*key_Cr)/0.5;
                z = max(min(z, 0.5), -0.5);

                if (abs(z) > min(x*accept_angle_tg, 0.5)) {
                    //在前景区，alpha=1.0
                    gl_FragColor.a = 1.0;
                } else {//在半透明和背景区
                    float x1 = abs(max(min(z*accept_angle_ctg, 0.5), -0.5));
                    float z1 = z;

                    float dx = max(x-x1, 0.0);
                    float kbg = dx*one_over_kc/2.0;
                    kbg = max(min(kbg, 1.0), 0.0);
                    y = y - min(dx*kfgy_scale, 1.0);//对y的处理，即减去（dx*系数）
                    y = max(y, 0.0);
                    //反变换，(x1, z1)旋转(-θ)角得到（cr, cb）. key_Cb对应cosθ, key_Cr对应sinθ
                    cb = (x1*key_Cb - z1*key_Cr)/0.5;
                    cb = max(min(cb, 0.5), -0.5);//溢出处理
                    cr = (x1*key_Cr + z1*key_Cb)/0.5;
                    cr = max(min(cr, 0.5), -0.5);

                    if ((z*z+(x-kg)*(x-kg)) < noise_level*noise_level) {//小于noise_level的部分认为是背景部分
                        gl_FragColor.rgb = vec3(0.0);
                        gl_FragColor.a = 0.0;
                    } else {//半透明区
                        float alpha = 1.0 - kbg;
                        alpha = smoothclip(0.2, 1.0, alpha);//
                        //y cb cr => r g b
                        float r = 1.164*y + 1.596*cr;
                        float g = 1.164*y - 0.813*cr - 0.392*cb;
                        float b = 1.164*y + 2.017*cb;
                        if(alpha < smoothL){//调节前景边缘黑边或白边问题
                            alpha = 0.0;
                            r = g = b = 0.0;
                        }
                        if(alpha > smoothH){
                            alpha = 1.0;
                        }
                        if(smoothH < 1.0){
                            alpha = alpha/max(smoothH, 0.9);
                        }
                        gl_FragColor.r = max(min(r, 1.0), 0.0);
                        gl_FragColor.g = max(min(g, 1.0), 0.0);
                        gl_FragColor.b = max(min(b, 1.0), 0.0);
                        gl_FragColor.a = alpha;
                    }
                }
            } else {
                if(algorithmType == 4){//机器学习方案
                    float diff = algorithmParam1.x;//用来区分公式
                    float balance = algorithmParam1.y;
                    float black = algorithmParam1.z;
                    float white = algorithmParam1.w;
                    float alpha = 1.0;
                    float x = v_texCoord.x;
                    float y = v_texCoord.y;
#if defined(DISPLAY_IMAGE)
    y = 1.0-y;
#endif
                    float bgR = max(min(u_screenColor.r, 1.0), 0.0);
                    float bgG = max(min(u_screenColor.g, 1.0), 0.0);
                    float bgB = max(min(u_screenColor.b, 1.0), 0.0);
                    float R = max(min(gl_FragColor.r, 1.0), 0.0);
                    float G = max(min(gl_FragColor.g, 1.0), 0.0);
                    float B = max(min(gl_FragColor.b, 1.0), 0.0);

if(diff > 0.95){//1.0 for GT

    alpha  = 0.74123234*R + 0.28143826*G - 1.83826196*B + 1.05570233;

}//gt end

if(diff > 0.65 && diff < 0.75){//0.7 for supercell begin

float R2 = R*R;
float G2 = G*G;
float B2 = B*B;
float RG = R*G;
float RB = R*B;
float GB = G*B;
float RGB = R*G*B;
alpha = 0.3513*R - 1.1087*G + 0.3776*B + 0.2717*R2 + 0.0784*G2 + 0.0648*B2 + 0.0849*RG + 0.1649*RB - 0.0785*GB - 0.1957*RGB + 1.0285;
alpha = max(min(alpha, 1.0), 0.0);
float fa = alpha;
float ba = alpha;
if (currentTime >= 0.0 && currentTime < 0.59607) {
    ba = fa = 0.364*R - 1.1132*G + 0.4248*B + 0.2513*R2 + 0.0674*G2 + 0.0466*B2 + 0.0759*RG + 0.1758*RB - 0.0911*GB - 0.2379*RGB + 1.0436;
}
if (currentTime >= 0.59607 && currentTime < 1.52847) {
    ba = fa = 0.3618*R - 1.1238*G + 0.414*B + 0.2759*R2 + 0.0766*G2 + 0.0332*B2 + 0.0588*RG + 0.1939*RB - 0.0957*GB - 0.2351*RGB + 1.0452;
}
if (currentTime >= 1.52847 && currentTime < 1.56177) {
    ba = fa = 0.3595*R - 1.1324*G + 0.4059*B + 0.2854*R2 + 0.0825*G2 + 0.0209*B2 + 0.0508*RG + 0.2076*RB - 0.1043*GB - 0.2337*RGB + 1.0479;
}
if (currentTime >= 1.56177 && currentTime < 1.59507) {
    ba = fa = 0.3003*R - 1.2893*G + 0.441*B + 0.3783*R2 + 0.2505*G2 + 0.0754*B2 + 0.0778*RG + 0.1361*RB - 0.1477*GB - 0.2459*RGB + 1.0371;
    if(fa > 0.0 && fa < 1.05){
        if (x>=0.0 && y>=0.0 && x<0.25 && y<0.25) {
            ba = 0.3003*R - 1.29*G + 0.441*B + 0.3783*R2 + 0.2498*G2 + 0.0754*B2 + 0.0778*RG + 0.1361*RB - 0.1477*GB - 0.2459*RGB + 1.0364;
        }
        if (x>=0.25 && y>=0.0 && x<0.5 && y<0.25) {
            ba = 0.4137*R - 1.322*G + 0.4259*B + 0.1879*R2 + 0.2199*G2 + 0.0414*B2 + 0.0968*RG + 0.2577*RB - 0.2426*GB - 0.2971*RGB + 1.0933;
        }
        if (x>=0.5 && y>=0.0 && x<0.75 && y<0.25) {
            ba = 0.4094*R - 1.3368*G + 0.471*B + 0.1357*R2 + 0.2025*G2 + 0.0688*B2 + 0.1222*RG + 0.2559*RB - 0.2146*GB - 0.2741*RGB + 1.1191;
        }
        if (x>=0.75 && y>=0.0 && x<=1.0 && y<0.25) {
            ba = 0.4094*R - 1.3368*G + 0.471*B + 0.1357*R2 + 0.2025*G2 + 0.0688*B2 + 0.1222*RG + 0.2559*RB - 0.2146*GB - 0.2741*RGB + 1.1191;
        }
        if (x>=0.0 && y>=0.25 && x<0.25 && y<0.5) {
            ba = 0.3392*R - 1.3333*G + 0.456*B + 0.1439*R2 + 0.2385*G2 + 0.1235*B2 + 0.1167*RG + 0.2041*RB - 0.1777*GB - 0.2348*RGB + 1.0844;
        }
        if (x>=0.25 && y>=0.25 && x<0.5 && y<0.5) {
            ba = 0.3989*R - 1.3574*G + 0.3775*B + 0.217*R2 + 0.236*G2 + 0.1146*B2 + 0.0938*RG + 0.2288*RB - 0.2047*GB - 0.2205*RGB + 1.115;
        }
        if (x>=0.5 && y>=0.25 && x<0.75 && y<0.5) {
            ba = 0.398*R - 1.3699*G + 0.3616*B + 0.2038*R2 + 0.2377*G2 + 0.1459*B2 + 0.0944*RG + 0.212*RB - 0.2131*GB - 0.2088*RGB + 1.1263;
        }
        if (x>=0.75 && y>=0.25 && x<=1.0 && y<0.5) {
            ba = 0.3627*R - 1.353*G + 0.3912*B + 0.1693*R2 + 0.2513*G2 + 0.1671*B2 + 0.1221*RG + 0.205*RB - 0.2094*GB - 0.2007*RGB + 1.0975;
        }
        if (x>=0.0 && y>=0.5 && x<0.25 && y<0.75) {
            ba = 0.3002*R - 1.3388*G + 0.4557*B + 0.12*R2 + 0.2053*G2 + 0.2743*B2 + 0.125*RG + 0.129*RB - 0.1623*GB - 0.1978*RGB + 1.1301;
        }
        if (x>=0.25 && y>=0.5 && x<0.5 && y<0.75) {
            ba = 0.3031*R - 1.337*G + 0.4563*B + 0.1225*R2 + 0.2064*G2 + 0.2742*B2 + 0.1254*RG + 0.1307*RB - 0.1616*GB - 0.1974*RGB + 1.1331;
        }
        if (x>=0.5 && y>=0.5 && x<0.75 && y<0.75) {
            ba =  - 0.0942*R - 1.4864*G + 0.2339*B + 0.5238*R2 + 0.4134*G2 + 0.2481*B2 + 0.124*RG + 0.5119*RB - 0.2948*GB - 0.0696*RGB + 1.0924;
        }
        if (x>=0.75 && y>=0.5 && x<=1.0 && y<0.75) {
            ba =  - 0.2077*R - 1.6572*G + 0.618*B + 0.3818*R2 + 0.3441*G2 + 0.4111*B2 + 0.1866*RG + 0.2166*RB - 0.137*GB - 0.0839*RGB + 1.308;
        }
        if (x>=0.0 && y>=0.75 && x<0.25 && y<=1.0) {
            ba =  - 0.1768*R - 1.6493*G + 0.631*B + 0.3285*R2 + 0.3308*G2 + 0.3828*B2 + 0.227*RG + 0.2834*RB - 0.176*GB - 0.1009*RGB + 1.3155;
        }
        if (x>=0.25 && y>=0.75 && x<0.5 && y<=1.0) {
            ba =  - 0.026*R - 1.456*G + 0.6233*B + 0.3612*R2 + 0.3088*G2 + 0.237*B2 + 0.1144*RG + 0.367*RB - 0.2384*GB - 0.2694*RGB + 1.1448;
        }
        if (x>=0.5 && y>=0.75 && x<0.75 && y<=1.0) {
            ba =  - 0.0685*R - 1.4464*G + 0.7642*B + 0.2934*R2 + 0.2998*G2 + 0.2973*B2 + 0.1274*RG + 0.2808*RB - 0.1806*GB - 0.3138*RGB + 1.1439;
        }
        if (x>=0.75 && y>=0.75 && x<=1.0 && y<=1.0) {
            ba =  - 0.0755*R - 1.4439*G + 0.7561*B + 0.2842*R2 + 0.303*G2 + 0.2953*B2 + 0.1233*RG + 0.2824*RB - 0.1849*GB - 0.3162*RGB + 1.1374;
        }
    }
}
if (currentTime >= 1.59507 && currentTime < 1.79487) {
    ba = fa = 0.3283*R - 1.301*G + 0.4525*B + 0.3535*R2 + 0.2142*G2 + 0.0372*B2 + 0.0857*RG + 0.1962*RB - 0.185*GB - 0.2667*RGB + 1.0841;
    if(fa > 0.0 && fa < 1.05){
        if (x>=0.0 && y>=0.0 && x<0.25 && y<0.25) {
            ba = 0.3283*R - 1.301*G + 0.4525*B + 0.3535*R2 + 0.2142*G2 + 0.0372*B2 + 0.0857*RG + 0.1962*RB - 0.185*GB - 0.2667*RGB + 1.0841;
        }
        if (x>=0.25 && y>=0.0 && x<0.5 && y<0.25) {
            ba = 0.3338*R - 1.3478*G + 0.4476*B + 0.2851*R2 + 0.244*G2 + 0.0571*B2 + 0.1285*RG + 0.2193*RB - 0.171*GB - 0.2045*RGB + 1.1014;
        }
        if (x>=0.5 && y>=0.0 && x<0.75 && y<0.25) {
            ba = 0.3318*R - 1.3616*G + 0.4473*B + 0.2547*R2 + 0.2735*G2 + 0.0574*B2 + 0.1325*RG + 0.2587*RB - 0.1641*GB - 0.1821*RGB + 1.0849;
        }
        if (x>=0.75 && y>=0.0 && x<=1.0 && y<0.25) {
            ba = 0.3318*R - 1.3616*G + 0.4473*B + 0.2547*R2 + 0.2735*G2 + 0.0574*B2 + 0.1325*RG + 0.2587*RB - 0.1641*GB - 0.1821*RGB + 1.0849;
        }
        if (x>=0.0 && y>=0.25 && x<0.25 && y<0.5) {
            ba = 0.3024*R - 1.3636*G + 0.4175*B + 0.2496*R2 + 0.2727*G2 + 0.0569*B2 + 0.1023*RG + 0.2263*RB - 0.1673*GB - 0.1853*RGB + 1.0888;
        }
        if (x>=0.25 && y>=0.25 && x<0.5 && y<0.5) {
            ba = 0.331*R - 1.4151*G + 0.4338*B + 0.1747*R2 + 0.1871*G2 + 0.1107*B2 + 0.1177*RG + 0.1596*RB - 0.1575*GB - 0.1641*RGB + 1.226;
        }
        if (x>=0.5 && y>=0.25 && x<0.75 && y<0.5) {
            ba = 0.3394*R - 1.4125*G + 0.3835*B + 0.2151*R2 + 0.2489*G2 + 0.1018*B2 + 0.1149*RG + 0.2069*RB - 0.1742*GB - 0.1461*RGB + 1.1619;
        }
        if (x>=0.75 && y>=0.25 && x<=1.0 && y<0.5) {
            ba = 0.3362*R - 1.4066*G + 0.392*B + 0.1963*R2 + 0.2386*G2 + 0.1036*B2 + 0.1148*RG + 0.1953*RB - 0.1802*GB - 0.1585*RGB + 1.1662;
        }
        if (x>=0.0 && y>=0.5 && x<0.25 && y<0.75) {
            ba = 0.3289*R - 1.3709*G + 0.4633*B + 0.1792*R2 + 0.2265*G2 + 0.1407*B2 + 0.1112*RG + 0.1572*RB - 0.1604*GB - 0.1874*RGB + 1.1421;
        }
        if (x>=0.25 && y>=0.5 && x<0.5 && y<0.75) {
            ba = 0.3306*R - 1.3665*G + 0.4659*B + 0.1781*R2 + 0.2255*G2 + 0.1388*B2 + 0.1103*RG + 0.1586*RB - 0.1616*GB - 0.191*RGB + 1.1403;
        }
        if (x>=0.5 && y>=0.5 && x<0.75 && y<0.75) {
            ba = 0.356*R - 1.3557*G + 0.3987*B + 0.3076*R2 + 0.2533*G2 + 0.0881*B2 + 0.0457*RG + 0.2345*RB - 0.1936*GB - 0.211*RGB + 1.1016;
        }
        if (x>=0.75 && y>=0.5 && x<=1.0 && y<0.75) {
            ba = 0.3465*R - 1.3581*G + 0.4107*B + 0.2681*R2 + 0.2333*G2 + 0.0792*B2 + 0.0575*RG + 0.2329*RB - 0.2127*GB - 0.2247*RGB + 1.1213;
        }
        if (x>=0.0 && y>=0.75 && x<0.25 && y<=1.0) {
            ba = 0.3428*R - 1.3507*G + 0.4205*B + 0.2689*R2 + 0.2388*G2 + 0.0877*B2 + 0.0614*RG + 0.23*RB - 0.2064*GB - 0.2225*RGB + 1.11;
        }
        if (x>=0.25 && y>=0.75 && x<0.5 && y<=1.0) {
            ba = 0.3223*R - 1.2659*G + 0.4803*B + 0.2237*R2 + 0.1771*G2 + 0.0899*B2 + 0.089*RG + 0.2293*RB - 0.2176*GB - 0.2401*RGB + 1.0864;
        }
        if (x>=0.5 && y>=0.75 && x<0.75 && y<=1.0) {
            ba = 0.2909*R - 1.2673*G + 0.4314*B + 0.3275*R2 + 0.1986*G2 + 0.0527*B2 + 0.0775*RG + 0.3226*RB - 0.2499*GB - 0.2306*RGB + 1.0669;
        }
        if (x>=0.75 && y>=0.75 && x<=1.0 && y<=1.0) {
            ba = 0.2853*R - 1.2671*G + 0.4285*B + 0.3257*R2 + 0.2011*G2 + 0.0522*B2 + 0.0751*RG + 0.3182*RB - 0.2509*GB - 0.2313*RGB + 1.0641;
        }
    }
}
if (currentTime >= 1.79487 && currentTime < 2.97333) {
    ba = fa = 0.3178*R - 1.3037*G + 0.4539*B + 0.3514*R2 + 0.212*G2 + 0.0264*B2 + 0.0844*RG + 0.2176*RB - 0.1943*GB - 0.2637*RGB + 1.0895;
}
fa = max(min(fa, 1.0), 0.0);
ba = max(min(ba, 1.0), 0.0);
alpha = ba;
if (fa != alpha) {
    float diff = abs(alpha-fa);
    float div = 25.0*diff;
    div = max(div, 1.0);
    if(div < 8.0){
        alpha = fa + (alpha-fa)/div;
    } else {
       alpha = fa;
    }
}


}//supercell end

if(diff > 0.55 && diff < 0.65){//0.6 for cat

float R2 = R*R;
float G2 = G*G;
float B2 = B*B;
float RG = R*G;
float RB = R*B;
float GB = G*B;
float RGB = R*G*B;
alpha = 1.1242*R - 1.9521*G + 0.5929*B + 0.7791*R2 - 0.9352*G2 - 0.0565*B2 + 0.0403*RG + 0.4279*RB + 0.3239*GB + 0.0785*RGB + 1.0052;
alpha = max(min(alpha, 1.0), 0.0);
float fa = alpha;
float ba = alpha;
if (currentTime >= 0.0 && currentTime < 6.65667) {
    ba = fa = 1.1919*R - 2.0592*G + 0.662*B + 0.7547*R2 - 0.8102*G2 - 0.1802*B2 + 0.0232*RG + 0.4597*RB + 0.2418*GB + 0.0402*RGB + 1.0059;
}
if (currentTime >= 6.65667 && currentTime < 14.01597) {
    ba = fa = 1.247*R - 2.1406*G + 0.7295*B + 0.7229*R2 - 0.7101*G2 - 0.2832*B2 + 0.007*RG + 0.478*RB + 0.1682*GB + 0.002*RGB + 1.005;
}
fa = max(min(fa, 1.0), 0.0);
ba = max(min(ba, 1.0), 0.0);
alpha = ba;
if (fa != alpha) {
    float diff = abs(alpha-fa);
    float div = 25.0*diff;
    div = max(div, 1.0);
    if(div < 8.0){
        alpha = fa + (alpha-fa)/div;
    } else {
       alpha = fa;
    }
}

}//cat end

if(diff > 0.45 && diff < 0.55){//baby begin
//alpha = 1.97282839*R -3.97356296*G + 2.01847243*B+0.99792415;

float R2 = R*R;
float G2 = G*G;
float B2 = B*B;
float RG = R*G;
float RB = R*B;
float GB = G*B;
float RGB = R*G*B;
alpha = 1.2521*R - 2.2446*G + 0.21*B + 1.1692*R2 - 1.5971*G2 + 0.5234*B2 - 0.2208*RG + 0.2693*RB + 0.7976*GB + 0.4523*RGB + 0.9912;
alpha = max(min(alpha, 1.0), 0.0);
float fa = alpha;
float ba = alpha;
if (currentTime >= 0.0 && currentTime < 9.876) {
    ba = fa = 1.4299*R - 2.3476*G + 0.2042*B + 1.1566*R2 - 1.5709*G2 + 0.4118*B2 - 0.1076*RG + 0.284*RB + 0.78*GB + 0.3453*RGB + 0.9867;
}
if (currentTime >= 9.956 && currentTime < 10.396) {
    ba = fa = 1.2671*R - 2.3183*G + 0.1997*B + 0.9662*R2 - 1.39*G2 + 0.6483*B2 - 0.0977*RG + 0.2267*RB + 0.7893*GB + 0.2897*RGB + 0.9936;
}
if (currentTime >= 10.396 && currentTime < 15.996) {
    ba = fa = 1.2443*R - 2.2773*G + 0.2786*B + 0.971*R2 - 1.6585*G2 + 0.4475*B2 - 0.2062*RG + 0.3647*RB + 0.9159*GB + 0.4313*RGB + 0.9969;
}
if (currentTime >= 15.996 && currentTime < 22.704) {
    ba = fa = 1.4781*R - 2.4279*G + 0.1546*B + 1.2127*R2 - 1.334*G2 + 0.2613*B2 - 0.3198*RG + 0.4172*RB + 0.8746*GB + 0.2332*RGB + 0.9831;
}
fa = max(min(fa, 1.0), 0.0);
ba = max(min(ba, 1.0), 0.0);
alpha = ba;
if (fa != alpha) {
    float diff = abs(alpha-fa);
    float div = 25.0*diff;
    div = max(div, 1.0);
    if(div < 8.0){
        alpha = fa + (alpha-fa)/div;
    } else {
       alpha = fa;
    }
}

}//baby end

                    alpha = alpha * balance;
                    alpha = max(min(alpha, 1.0), 0.0);
                    if(alpha <= 0.0){
                        R = G = B = 0.0;
                    } else {
                        R = R - (1.0-alpha)*bgR;
                        G = G - (1.0-alpha)*bgG;
                        B = B - (1.0-alpha)*bgB;
                    }
                    alpha = max(min(alpha, white), black);
                    alpha = (alpha-black)/(white-black);
                    R = max(min(R, 1.0), 0.0);
                    G = max(min(G, 1.0), 0.0);
                    B = max(min(B, 1.0), 0.0);
                    gl_FragColor.a = alpha;
                    gl_FragColor.r = R;
                    gl_FragColor.g = G;
                    gl_FragColor.b = B;
                } else {
                    if(algorithmType == 5){
                        float u_clipBlack = algorithmParam1.x;
                        float u_clipWhite = algorithmParam1.y;
                        float dis = distance(gl_FragColor.rgb, u_screenColor.rgb);
                        float alpha = smoothclip(u_clipBlack, u_clipWhite, dis);
                        gl_FragColor.a = alpha;
                        gl_FragColor.rgb = gl_FragColor.rgb - (1.0-alpha)*u_screenColor.rgb;
                    } else {
                        //不处理，还原视频原样
                    }
                }
            }
        }
    }
    if(mode == 1){//Alpha通道
        gl_FragColor.rgb = vec3(gl_FragColor.a);
        gl_FragColor.a = 1.0;
        return;
    }
    if(mode == 2){//白底
        gl_FragColor.rgb = mix(vec3(1.0), gl_FragColor.rgb, gl_FragColor.a);
        gl_FragColor.a = 1.0;
        return;
    }
    if(mode == 3){//黑底
        gl_FragColor.rgb = mix(vec3(0.0), gl_FragColor.rgb, gl_FragColor.a);
        gl_FragColor.a = 1.0;
        return;
    }
}