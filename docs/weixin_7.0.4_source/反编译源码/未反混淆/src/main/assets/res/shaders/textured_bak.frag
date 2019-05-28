
precision mediump float;


///////////////////////////////////////////////////////////
// Uniforms
uniform sampler2D u_diffuseTexture;


///////////////////////////////////////////////////////////
// Variables
vec4 _baseColor;

///////////////////////////////////////////////////////////
// Varyings
varying vec2 v_texCoord;

void main()
{
    _baseColor =  texture2D(u_diffuseTexture, v_texCoord);

    gl_FragColor.a = _baseColor.a;

    gl_FragColor.rgb = _baseColor.rgb;

}