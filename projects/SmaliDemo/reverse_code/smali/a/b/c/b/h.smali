.class La/b/c/b/h;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements La/b/c/b/j$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = La/b/c/b/j;->a([La/b/c/d/f$b;I)La/b/c/d/f$b;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "La/b/c/b/j$a<",
        "La/b/c/d/f$b;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic a:La/b/c/b/j;


# direct methods
.method constructor <init>(La/b/c/b/j;)V
    .locals 0
    .param p1, "this$0"    # La/b/c/b/j;

    .line 71
    iput-object p1, p0, La/b/c/b/h;->a:La/b/c/b/j;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(La/b/c/d/f$b;)I
    .locals 1
    .param p1, "info"    # La/b/c/d/f$b;

    .line 74
    invoke-virtual {p1}, La/b/c/d/f$b;->d()I

    move-result v0

    return v0
.end method

.method public bridge synthetic a(Ljava/lang/Object;)I
    .locals 0

    .line 71
    check-cast p1, La/b/c/d/f$b;

    invoke-virtual {p0, p1}, La/b/c/b/h;->a(La/b/c/d/f$b;)I

    move-result p1

    return p1
.end method

.method public b(La/b/c/d/f$b;)Z
    .locals 1
    .param p1, "info"    # La/b/c/d/f$b;

    .line 79
    invoke-virtual {p1}, La/b/c/d/f$b;->e()Z

    move-result v0

    return v0
.end method

.method public bridge synthetic b(Ljava/lang/Object;)Z
    .locals 0

    .line 71
    check-cast p1, La/b/c/d/f$b;

    invoke-virtual {p0, p1}, La/b/c/b/h;->b(La/b/c/d/f$b;)Z

    move-result p1

    return p1
.end method
