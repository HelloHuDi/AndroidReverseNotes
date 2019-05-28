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
// Atributes
attribute vec4 a_position;

#if defined(SKINNING)
attribute vec4 a_blendWeights;
attribute vec4 a_blendIndices;
#endif

#if defined(TEXTURECUBE)
attribute vec3 a_texCoord;
#else
#if !defined(TEXTURE_ORIGIN)
attribute vec2 a_texCoord;
#endif
#endif


#if defined(LIGHTMAP)
attribute vec2 a_texCoord1;
#endif

#if defined(LIGHTING)
attribute vec3 a_normal;

#if defined(BUMPED)
attribute vec3 a_tangent;
attribute vec3 a_binormal;
#endif

#endif

///////////////////////////////////////////////////////////
// Uniforms
uniform mat4 u_worldViewProjectionMatrix;
#if defined(SKINNING)
uniform vec4 u_matrixPalette[SKINNING_JOINT_COUNT * 3];
#endif

#if defined(LIGHTING)
uniform mat4 u_inverseTransposeWorldViewMatrix;

#if defined(SPECULAR) || (POINT_LIGHT_COUNT > 0) || (SPOT_LIGHT_COUNT > 0)
uniform mat4 u_worldViewMatrix;
#endif

#if defined(BUMPED) && (DIRECTIONAL_LIGHT_COUNT > 0)
uniform vec3 u_directionalLightDirection[DIRECTIONAL_LIGHT_COUNT];
#endif

#if (POINT_LIGHT_COUNT > 0)
uniform vec3 u_pointLightPosition[POINT_LIGHT_COUNT];
#endif

#if (SPOT_LIGHT_COUNT > 0)
uniform vec3 u_spotLightPosition[SPOT_LIGHT_COUNT];
#if defined(BUMPED)
uniform vec3 u_spotLightDirection[SPOT_LIGHT_COUNT];
#endif
#endif

#if defined(SPECULAR)
uniform vec3 u_cameraPosition;
#endif

#endif

#if defined(TEXTURE_REPEAT)
#if defined(TEXTURECUBE)
uniform vec3 u_textureRepeat;
#else
uniform vec2 u_textureRepeat;
#endif
#endif

#if defined(TEXTURE_OFFSET)
#if defined(TEXTURECUBE)
uniform vec3 u_textureOffset;
#else
uniform vec2 u_textureOffset;
#endif
#endif

#if defined(TEXTURE_MATRIX)
uniform mat4 uTextureMatrix;
#endif

#if defined(CLIP_PLANE)
uniform mat4 u_worldMatrix;
uniform vec4 u_clipPlane;
#endif

#if defined(GROUND_VEX)
uniform vec2 u_textureSize;
#endif

///////////////////////////////////////////////////////////
// Varyings
#if defined(TEXTURECUBE)
varying vec3 v_texCoord;
#else
varying vec2 v_texCoord;
#endif

#if defined(GROUND_VEX)
varying vec2 v_texCoord_g[8];
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

#include "lighting.vert"

#endif

#if defined(SKINNING)
#include "skinning.vert"
#else
#include "skinning-none.vert"
#endif

#if defined(CLIP_PLANE)
varying float v_clipDistance;
#endif

void main()
{
    vec4 position = getPosition();

    gl_Position = u_worldViewProjectionMatrix * position;

#if defined(LIGHTING)
    vec3 normal = getNormal();
    // Transform the normal, tangent and binormals to view space.
    mat3 inverseTransposeWorldViewMatrix = mat3(u_inverseTransposeWorldViewMatrix[0].xyz, u_inverseTransposeWorldViewMatrix[1].xyz, u_inverseTransposeWorldViewMatrix[2].xyz);
    vec3 normalVector = normalize(inverseTransposeWorldViewMatrix * normal);

    #if defined(BUMPED)

    vec3 tangent = getTangent();
    vec3 binormal = getBinormal();
    vec3 tangentVector  = normalize(inverseTransposeWorldViewMatrix * tangent);
    vec3 binormalVector = normalize(inverseTransposeWorldViewMatrix * binormal);
    mat3 tangentSpaceTransformMatrix = mat3(tangentVector.x, binormalVector.x, normalVector.x, tangentVector.y, binormalVector.y, normalVector.y, tangentVector.z, binormalVector.z, normalVector.z);
    applyLight(position, tangentSpaceTransformMatrix);

    #else

    v_normalVector = normalVector;
    applyLight(position);

    #endif

#endif

    //v_texCoord = a_texCoord;
#if defined(TEXTURE_MATRIX)
    vec4 coordValue = uTextureMatrix * vec4(a_texCoord.x,a_texCoord.y,0.0,1.0);
        v_texCoord = vec2(coordValue.xy);
#else
#if defined(TEXTURE_ORIGIN)
    v_texCoord = vec2(gl_Position.x / gl_Position.w * 0.5 + 0.5, gl_Position.y  / gl_Position.w * 0.5 + 0.5);
#else
    v_texCoord = a_texCoord;
    //v_texCoord = vec2(gl_Position.x / gl_Position.w * 0.5 + 0.5, 1. - (gl_Position.y  / gl_Position.w * 0.5 + 0.5));
    //gl_Position = vec4((a_texCoord.x - 0.5) * 2., (a_texCoord.y - 0.5) * 2., 0, 1.);
#endif
#endif

#if defined(TEXTURE_REPEAT)
    v_texCoord *= u_textureRepeat;
#endif

#if defined(TEXTURE_OFFSET)
    v_texCoord += u_textureOffset;
#endif

#if defined(LIGHTMAP)
    v_texCoord1 = a_texCoord1;
#endif

#if defined(CLIP_PLANE)
    v_clipDistance = dot(u_worldMatrix * position, u_clipPlane);
#endif

#if defined(GROUND_VEX)
    float dx = 1.05/max(1.0, u_textureSize.x);
    float dy = 1.05/max(1.0, u_textureSize.y);
    v_texCoord_g[0].x = min(1.0, max(0.0, v_texCoord.x + dx));
    v_texCoord_g[0].y = v_texCoord.y;

    v_texCoord_g[1].x = min(1.0, max(0.0, v_texCoord.x - dx));
    v_texCoord_g[1].y = v_texCoord.y;

    v_texCoord_g[2].x = min(1.0, max(0.0, v_texCoord.x - dx));
    v_texCoord_g[2].y = min(1.0, max(0.0, v_texCoord.y - dy));

    v_texCoord_g[3].x = min(1.0, max(0.0, v_texCoord.x + dx));
    v_texCoord_g[3].y = min(1.0, max(0.0, v_texCoord.y - dy));

    v_texCoord_g[4].x = min(1.0, max(0.0, v_texCoord.x - dx));
    v_texCoord_g[4].y = min(1.0, max(0.0, v_texCoord.y + dy));

    v_texCoord_g[5].x = min(1.0, max(0.0, v_texCoord.x + dx));
    v_texCoord_g[5].y = min(1.0, max(0.0, v_texCoord.y + dy));

    v_texCoord_g[6].x = v_texCoord.x;
    v_texCoord_g[6].y = min(1.0, max(0.0, v_texCoord.y + dy));

    v_texCoord_g[7].x = v_texCoord.x;
    v_texCoord_g[7].y = min(1.0, max(0.0, v_texCoord.y - dy));
#endif
}
