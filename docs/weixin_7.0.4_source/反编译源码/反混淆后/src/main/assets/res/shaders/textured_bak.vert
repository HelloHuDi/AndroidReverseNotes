
///////////////////////////////////////////////////////////
// Atributes
attribute vec4 a_position;

///////////////////////////////////////////////////////////
// Uniforms
uniform mat4 u_worldViewProjectionMatrix;

///////////////////////////////////////////////////////////
// Varyings

varying vec2 v_texCoord;

void main()
{
    vec4 position = a_position;
    gl_Position = u_worldViewProjectionMatrix * position;

    v_texCoord = vec2(gl_Position.x / gl_Position.w * 0.5 + 0.5, gl_Position.y / gl_Position.w * 0.5 + 0.5);

}
