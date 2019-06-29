.class final La/b/c/g/t;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/view/View$OnApplyWindowInsetsListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = La/b/c/g/u;->a(Landroid/view/View;La/b/c/g/q;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic a:La/b/c/g/q;


# direct methods
.method constructor <init>(La/b/c/g/q;)V
    .locals 0

    .line 2209
    iput-object p1, p0, La/b/c/g/t;->a:La/b/c/g/q;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onApplyWindowInsets(Landroid/view/View;Landroid/view/WindowInsets;)Landroid/view/WindowInsets;
    .locals 2
    .param p1, "view"    # Landroid/view/View;
    .param p2, "insets"    # Landroid/view/WindowInsets;

    .line 2212
    invoke-static {p2}, La/b/c/g/E;->a(Ljava/lang/Object;)La/b/c/g/E;

    move-result-object v0

    .line 2213
    .local v0, "compatInsets":La/b/c/g/E;
    iget-object v1, p0, La/b/c/g/t;->a:La/b/c/g/q;

    invoke-interface {v1, p1, v0}, La/b/c/g/q;->a(Landroid/view/View;La/b/c/g/E;)La/b/c/g/E;

    move-result-object v0

    .line 2214
    invoke-static {v0}, La/b/c/g/E;->a(La/b/c/g/E;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/view/WindowInsets;

    return-object v1
.end method
