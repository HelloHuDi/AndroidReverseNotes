#if defined(SURFACE_TEXTURE)
#if defined(VIDEO_YUV)
#include "android_head_2video.frag"
#else
#include "android_head.frag"
#endif
#else

#ifdef OPENGL_ES
#ifdef GL_FRAGMENT_PRECISION_HIGH
precision highp float;
#else
precision mediump float;
#endif
#endif


#ifndef DIRECTIONAL_LIGHT_COUNT
#define DIRECTIONAL_LIGHT_COUNT 0
#endif
#ifndef SPOT_LIGHT_COUNT
#define SPOT_LIGHT_COUNT 0
#endif
#ifndef POINT_LIGHT_COUNT
#define POINT_LIGHT_COUNT 0
#endif
#if (DIRECTIONAL_LIGHT_COUNT > 0) || (POINT_LIGHT_COUNT > 0) || (SPOT_LIGHT_COUNT > 0)
#define LIGHTING
#endif

///////////////////////////////////////////////////////////
// Uniforms
uniform vec3 u_ambientColor;

//uniform sampler2D u_diffuseTexture;

// Uniforms
#if defined(TEXTURECUBE)
uniform samplerCube u_diffuseTexture;
#else
    #if defined(SURFACE_TEXTURE)
    uniform samplerExternalOES u_diffuseTexture;
    #else
    uniform sampler2D u_diffuseTexture;
    #endif
#endif

#if defined(TEXTURE_CUBE_MAP)
uniform float u_zNormalOffset;
uniform float u_cubeBlendFactor;
uniform sampler2D u_cubeTexture;
#endif

#if defined(CUBE_MAP_BLEND_MODE)
uniform float u_blendMode;
#endif

#if defined(YUV_420)
uniform int videoFormat;
uniform sampler2D u_diffuseTextureY;
uniform sampler2D u_diffuseTextureUV;
uniform mat4 COLOR_MATRIX;
#endif


#if defined(LIGHTMAP)
uniform sampler2D u_lightmapTexture;
#endif

#if defined(LIGHTING)

#if defined(BUMPED)
uniform sampler2D u_normalmapTexture;
#endif

#if (DIRECTIONAL_LIGHT_COUNT > 0)
uniform vec3 u_directionalLightColor[DIRECTIONAL_LIGHT_COUNT];
#if !defined(BUMPED)
uniform vec3 u_directionalLightDirection[DIRECTIONAL_LIGHT_COUNT];
#endif
#endif

#if (POINT_LIGHT_COUNT > 0)
uniform vec3 u_pointLightColor[POINT_LIGHT_COUNT];
uniform vec3 u_pointLightPosition[POINT_LIGHT_COUNT];
uniform float u_pointLightRangeInverse[POINT_LIGHT_COUNT];
#endif

#if (SPOT_LIGHT_COUNT > 0)
uniform vec3 u_spotLightColor[SPOT_LIGHT_COUNT];
uniform float u_spotLightRangeInverse[SPOT_LIGHT_COUNT];
uniform float u_spotLightInnerAngleCos[SPOT_LIGHT_COUNT];
uniform float u_spotLightOuterAngleCos[SPOT_LIGHT_COUNT];
#if !defined(BUMPED)
uniform vec3 u_spotLightDirection[SPOT_LIGHT_COUNT];
#endif
#endif

#if defined(SPECULAR)
uniform float u_specularExponent;
#endif

#endif

#if defined(MODULATE_COLOR)
uniform vec4 u_modulateColor;
#endif

#if defined(MODULATE_ALPHA)
uniform float u_modulateAlpha;
#endif

///////////////////////////////////////////////////////////
// chroma key algrithm uniforms
#if defined(CHROMA_KEY)
uniform vec4 u_screenColor;

#if defined(SCREEN_WEIGHT)
uniform float u_screenWeight;
#endif

#if defined(BALANCE)
uniform float u_balance;
#endif

#if defined(CLIP_BLACK)
uniform float u_clipBlack;
#endif

#if defined(CLIP_WHITE)
uniform float u_clipWhite;
#endif
#endif
///////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////
// Variables
vec4 _baseColor;

///////////////////////////////////////////////////////////
// Varyings
#if defined(TEXTURECUBE)
varying vec3 v_texCoord;
#else
varying vec2 v_texCoord;
#endif

#if defined(LIGHTMAP)
varying vec2 v_texCoord1;
#endif

#if defined(LIGHTING)

#if !defined(BUMPED)
varying vec3 v_normalVector;
#endif

#if defined(BUMPED) && (DIRECTIONAL_LIGHT_COUNT > 0)
varying vec3 v_directionalLightDirection[DIRECTIONAL_LIGHT_COUNT];
#endif

#if (POINT_LIGHT_COUNT > 0)
varying vec3 v_vertexToPointLightDirection[POINT_LIGHT_COUNT];
#endif

#if (SPOT_LIGHT_COUNT > 0)
varying vec3 v_vertexToSpotLightDirection[SPOT_LIGHT_COUNT];
#if defined(BUMPED)
varying vec3 v_spotLightDirection[SPOT_LIGHT_COUNT];
#endif
#endif

#if defined(SPECULAR)
varying vec3 v_cameraDirection;
#endif

#include "lighting.frag"

#endif

#if defined(CLIP_PLANE)
varying float v_clipDistance;
#endif

void main()
{
    #if defined(CLIP_PLANE)
    if(v_clipDistance < 0.0) discard;
    #endif


#if defined(YUV_420)

    vec4 yuvData;
    yuvData.x = texture2D(u_diffuseTextureY, v_texCoord).x;
   	vec2 uv = texture2D(u_diffuseTextureUV, v_texCoord).ra;
   	if(videoFormat == 17){//nv12
   	  yuvData.z = uv.x;
	  yuvData.y = uv.y;
   	}else{//nv21
   	  yuvData.z = uv.y;
	  yuvData.y = uv.x;
   	}

	yuvData.w = 1.0;
    _baseColor =  COLOR_MATRIX * yuvData;

#else
#if defined(TEXTURE_CUBE_MAP)
    vec3 I = normalize(v_cameraDirection * -1.0);
    //float scale = 1. / v_normalVector.z;
    //vec3 adjustNormal = vec3(v_normalVector.x * scale, v_normalVector.y * scale, 1. + u_zNormalOffset);
    vec3 adjustNormal = vec3(v_normalVector.x, v_normalVector.y, v_normalVector.z * u_zNormalOffset);
    vec3 R = reflect(I, normalize(adjustNormal));
    //_baseColor = textureCube(u_cubeTexture, R);
    //vec4 cubeTextureColor = textureCube(u_cubeTexture, R);
    //float theta = acos(R.z / sqrt(R.x * R.x + R.y * R.y + R.z * R.z));
    //float cosTheta2 = cos(theta / 8.0);
    //R.z = sqrt((R.x * R.x + R.y * R.y) / ( 1.0 / (cosTheta2 * cosTheta2) - 1.0));
    //R = normalize(R);
    float vp1 = 0.0;
    float vp2 = 0.0;
    float vp3 = -1.0;
    float n1 = 0.0;
    float n2 = 0.0;
    float n3 = 0.5;
    float v1 = R.x;
    float v2 = R.y;
    float v3 = R.z;
    float m1 = 0.0;
    float m2 = 0.0;
    float m3 = 0.0;
    float vpt = v1 * vp1 + v2 * vp2 + v3 * vp3;
    float t = ((n1 - m1) * vp1 + (n2 - m2) * vp2 + (n3 - m3) * vp3) / vpt;
    vec4 cubeTextureColor = vec4(1.0, 1.0, 1.0, 1.0);
    float r = m1 + v1 * t;
    float g = m2 + v2 * t;
    //if (r < 0.0) {
    //    r = -r;
    //}
    //if (g < 0.0) {
    //    g = -g;
    //}
    //cubeTextureColor.r = r;
    //cubeTextureColor.g = g;
    //cubeTextureColor.b = 0.0;
    //cubeTextureColor.a = 1.0;
#if defined(NO_REFLECT_MAP)
    cubeTextureColor = texture2D(u_cubeTexture, vec2(v_texCoord.x, 1.0 - v_texCoord.y));
#else
    cubeTextureColor = texture2D(u_cubeTexture, vec2(r + 0.5, 1.0 - (g + 0.5)));
#endif

    vec4 diffuseTextureColor = texture2D(u_diffuseTexture, v_texCoord);
    if(diffuseTextureColor.a > 0.0) {
        #if defined(CUBE_MAP_BLEND_MODE)
            // u_blendMode理论上用int就行了，但在一些机型上，用int的时候不知为何值传不进来，一直是0，用float就好了，所以下面写成这样
            if (0.5 < u_blendMode && u_blendMode < 1.5) {
                vec3 vOne = vec3(1.0, 1.0, 1.0);
                _baseColor = vec4(vOne - (vOne - diffuseTextureColor.rgb) * (vOne - cubeTextureColor.rgb), 1.0);
                _baseColor = mix(diffuseTextureColor, _baseColor, u_cubeBlendFactor);
            } else {
                _baseColor = mix(diffuseTextureColor, cubeTextureColor, u_cubeBlendFactor);
            }
        #else
            _baseColor = mix(diffuseTextureColor, cubeTextureColor, u_cubeBlendFactor);
        #endif
    } else{
        _baseColor = diffuseTextureColor;
    }

#else
    _baseColor =  texture2D(u_diffuseTexture, v_texCoord);
#endif
#endif

    gl_FragColor.a = _baseColor.a;

    #if defined(TEXTURE_DISCARD_ALPHA)
    if (gl_FragColor.a < 0.5)
        discard;
    #endif

    #if defined(LIGHTING)

    gl_FragColor.rgb = getLitPixel();
    #else
    gl_FragColor.rgb = _baseColor.rgb;
    #endif

	#if defined(LIGHTMAP)
	vec4 lightColor = texture2D(u_lightmapTexture, v_texCoord1);
	gl_FragColor.rgb *= lightColor.rgb;
	#endif

    #if defined(MODULATE_COLOR)
    gl_FragColor *= u_modulateColor;
    #endif

    #if defined(MODULATE_ALPHA)
    gl_FragColor.a *= u_modulateAlpha;
    #endif

#if defined(CHROMA_KEY)
    //chroma key算法，从github上抄的 brianchirls/Seriously.js/effects/seriously.chroma.js

#if !defined(SCREEN_WEIGHT)
    float u_screenWeight = 1.0;
#endif

#if !defined(BALANCE)
    float u_balance = 1.0;
#endif

#if !defined(CLIP_BLACK)
    float u_clipBlack = 0.0;
#endif

#if !defined(CLIP_WHITE)
    float u_clipWhite = 1.0;
#endif

    //待优化，screenPrimary，screenSat应该在CPU中计算，对于每个像素都是一样的
    float screenFmin = min(min(u_screenColor.r, u_screenColor.g), u_screenColor.b);
    float screenFmax = max(max(u_screenColor.r, u_screenColor.g), u_screenColor.b);
    vec3 screenPrimary = step(screenFmax, u_screenColor.rgb);
    float secondaryComponents = dot(1.0 - screenPrimary, u_screenColor.rgb);
    float screenSat = screenFmax - mix(secondaryComponents - screenFmin, secondaryComponents / 2.0, u_balance);

    float fmin = min(min(gl_FragColor.r, gl_FragColor.g), gl_FragColor.b);
    float fmax = max(max(gl_FragColor.r, gl_FragColor.g), gl_FragColor.b);
    //	luminance = fmax

    vec3 pixelPrimary = step(fmax, gl_FragColor.rgb);

    secondaryComponents = dot(1.0 - pixelPrimary, gl_FragColor.rgb);
    float pixelSat = fmax - mix(secondaryComponents - fmin, secondaryComponents / 2.0, u_balance); // Saturation

    // solid pixel if primary color component is not the same as the screen color
    float diffPrimary = dot(abs(pixelPrimary - screenPrimary), vec3(1.0));
    float solid = step(1.0, step(pixelSat, 0.1) + step(fmax, 0.1) + diffPrimary);

    /*
     Semi-transparent pixel if the primary component matches but if saturation is less
     than that of screen color. Otherwise totally transparent
     */
    float alpha = max(0.0, 1.0 - pixelSat / screenSat);
    alpha = smoothstep(u_clipBlack, u_clipWhite, alpha);
    vec4 semiTransparentPixel = vec4((gl_FragColor.rgb - (1.0 - alpha) * u_screenColor.rgb * u_screenWeight) / max(0.00001, alpha), alpha);

    vec4 pixel = mix(semiTransparentPixel, gl_FragColor, solid);

    gl_FragColor = vec4(1.0, 1.0, 0.0, 1.0);
#endif
}

#endif