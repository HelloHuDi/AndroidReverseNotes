.class public final La/b/c/a/a/c$b;
.super Ljava/lang/Object;
.source ""

# interfaces
.implements La/b/c/a/a/c$a;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = La/b/c/a/a/c;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "b"
.end annotation


# instance fields
.field private final a:[La/b/c/a/a/c$c;


# direct methods
.method public constructor <init>([La/b/c/a/a/c$c;)V
    .locals 0
    .param p1, "entries"    # [La/b/c/a/a/c$c;

    .line 153
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 154
    iput-object p1, p0, La/b/c/a/a/c$b;->a:[La/b/c/a/a/c$c;

    .line 155
    return-void
.end method


# virtual methods
.method public a()[La/b/c/a/a/c$c;
    .locals 1

    .line 158
    iget-object v0, p0, La/b/c/a/a/c$b;->a:[La/b/c/a/a/c$c;

    return-object v0
.end method
