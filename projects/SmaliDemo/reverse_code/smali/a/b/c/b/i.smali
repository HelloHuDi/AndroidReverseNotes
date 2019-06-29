.class La/b/c/b/i;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements La/b/c/b/j$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = La/b/c/b/j;->a(La/b/c/a/a/c$b;I)La/b/c/a/a/c$c;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "La/b/c/b/j$a<",
        "La/b/c/a/a/c$c;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:La/b/c/b/j;


# direct methods
.method constructor <init>(La/b/c/b/j;)V
    .locals 0
    .param p1, "this$0"    # La/b/c/b/j;

    .line 124
    iput-object p1, p0, La/b/c/b/i;->a:La/b/c/b/j;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(La/b/c/a/a/c$c;)I
    .locals 1
    .param p1, "entry"    # La/b/c/a/a/c$c;

    .line 127
    invoke-virtual {p1}, La/b/c/a/a/c$c;->e()I

    move-result v0

    return v0
.end method

.method public bridge synthetic a(Ljava/lang/Object;)I
    .locals 0

    .line 124
    check-cast p1, La/b/c/a/a/c$c;

    invoke-virtual {p0, p1}, La/b/c/b/i;->a(La/b/c/a/a/c$c;)I

    move-result p1

    return p1
.end method

.method public b(La/b/c/a/a/c$c;)Z
    .locals 1
    .param p1, "entry"    # La/b/c/a/a/c$c;

    .line 132
    invoke-virtual {p1}, La/b/c/a/a/c$c;->f()Z

    move-result v0

    return v0
.end method

.method public bridge synthetic b(Ljava/lang/Object;)Z
    .locals 0

    .line 124
    check-cast p1, La/b/c/a/a/c$c;

    invoke-virtual {p0, p1}, La/b/c/b/i;->b(La/b/c/a/a/c$c;)Z

    move-result p1

    return p1
.end method
