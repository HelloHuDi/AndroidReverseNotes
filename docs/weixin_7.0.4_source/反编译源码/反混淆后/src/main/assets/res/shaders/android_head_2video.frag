precision mediump float;      // highp here doesn't seem to matter, 双视频YUV方案

varying vec2 v_texCoord;
uniform sampler2D u_diffuseTextureY;
uniform sampler2D u_diffuseTextureUV;
uniform sampler2D u_diffuseTextureAlphaY;
uniform sampler2D u_diffuseTextureAlphaUV;

#if defined(DISPLAY_IMAGE)
uniform sampler2D u_diffuseTexture;//图片
uniform sampler2D u_diffuseTextureAlpha;//图片
#endif

uniform int mode;//显示模式
uniform vec4 u_screenColor;//屏幕色
uniform vec4 u_borderColor;//边缘颜色
uniform vec4 algorithmParam1;//算法参数
uniform vec4 algorithmParam2;//算法参数

void main() {
float balance = algorithmParam1.x;
float black = algorithmParam1.y;
float white = algorithmParam1.z;
float border_light = algorithmParam1.w;

#if defined(DISPLAY_IMAGE)
    vec4 _baseColor =  texture2D(u_diffuseTexture, v_texCoord);
    gl_FragColor.a = _baseColor.a;
    gl_FragColor.rgb = _baseColor.rgb;
    if(mode == 4){//源
        return;
    }
    float alpha = texture2D(u_diffuseTextureAlpha, v_texCoord).b;
    if(mode == 1){//alpha通道
        gl_FragColor.rgb = vec3(alpha);
        gl_FragColor.a = 1.0;
        return;
    }

    alpha = alpha * balance;
    alpha = max(0.0, min(1.0, alpha));

    gl_FragColor.rgb = gl_FragColor.rgb - (1.0-alpha)*u_screenColor.rgb;
    if(alpha > 0.065 && alpha < 0.935){
        vec3 add = gl_FragColor.rgb/alpha - gl_FragColor.rgb;
        gl_FragColor.rgb += (add*border_light);
    }
    gl_FragColor.rgb = max(min(gl_FragColor.rgb, 1.0), 0.0);

    alpha = max(black, min(white, alpha));
    alpha = (alpha-black)/(white-black);
    gl_FragColor.a = alpha;
#else
    //RGB画面
    vec4 yuv;
    yuv.x = texture2D(u_diffuseTextureY, v_texCoord).r;//Y
    vec2 uv = texture2D(u_diffuseTextureUV, v_texCoord).ra;//UV
    yuv.y = uv.x-0.5;//YUV420sp NV21
    yuv.z = uv.y-0.5;
    yuv.w = 1.0;
    gl_FragColor.rgb = mat3(1.0, 1.0, 1.0, 0.0, -0.34414, 1.772, 1.402, -0.71414, 0.0) * yuv.rgb;//yuv->rgb
    if(mode == 4){//源
        gl_FragColor.a = 1.0;
        return;
    }
    //alpha画面
    vec4 yuvAlpha;
    yuvAlpha.x = texture2D(u_diffuseTextureAlphaY, v_texCoord).r;//Y
    vec2 uvAlpha = texture2D(u_diffuseTextureAlphaUV, v_texCoord).ra;//UV
    yuvAlpha.y = uvAlpha.x-0.5;//YUV420sp NV21
    yuvAlpha.z = uvAlpha.y-0.5;
    yuvAlpha.w = 1.0;
    vec4 alphaColor;
    alphaColor.rgb = mat3(1.0, 1.0, 1.0, 0.0, -0.34414, 1.772, 1.402, -0.71414, 0.0) * yuvAlpha.rgb;//yuv->rgb
    if(mode == 1){//alpha通道
        gl_FragColor.rgb = vec3(alphaColor.r);
        gl_FragColor.a = 1.0;
        return;
    }
    float alpha = alphaColor.r;
    alpha = alpha * balance;
    alpha = max(0.0, min(1.0, alpha));
    if(alpha > 0.065 && alpha < 0.935){
        vec3 add = gl_FragColor.rgb/alpha - gl_FragColor.rgb;
        gl_FragColor.rgb += (add*border_light);
    }
    gl_FragColor.rgb = max(min(gl_FragColor.rgb, 1.0), 0.0);
    alpha = max(black, min(white, alpha));
    alpha = (alpha-black)/(white-black);
    gl_FragColor.a = alpha;
#endif
    if(mode == 2){//白底
        gl_FragColor.rgb = mix(vec3(1.0), gl_FragColor.rgb, gl_FragColor.a);
        gl_FragColor.a = 1.0;
    }
    if(mode == 3){//黑底
        gl_FragColor.rgb = mix(vec3(0.0), gl_FragColor.rgb, gl_FragColor.a);
        gl_FragColor.a = 1.0;
    }
}