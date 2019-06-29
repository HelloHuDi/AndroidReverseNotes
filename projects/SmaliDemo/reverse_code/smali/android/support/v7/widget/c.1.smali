.class Landroid/support/v7/widget/c;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Landroid/support/v7/widget/ActionBarContextView;->a(La/b/d/d/b;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic a:La/b/d/d/b;

.field final synthetic b:Landroid/support/v7/widget/ActionBarContextView;


# direct methods
.method constructor <init>(Landroid/support/v7/widget/ActionBarContextView;La/b/d/d/b;)V
    .locals 0
    .param p1, "this$0"    # Landroid/support/v7/widget/ActionBarContextView;

    .line 170
    iput-object p1, p0, Landroid/support/v7/widget/c;->b:Landroid/support/v7/widget/ActionBarContextView;

    iput-object p2, p0, Landroid/support/v7/widget/c;->a:La/b/d/d/b;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .line 173
    iget-object v0, p0, Landroid/support/v7/widget/c;->a:La/b/d/d/b;

    invoke-virtual {v0}, La/b/d/d/b;->a()V

    .line 174
    return-void
.end method
