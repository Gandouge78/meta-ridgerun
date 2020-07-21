SUMMARY = "GStreamer Perf 1.0"
DESCRIPTION = "GStreamer element to measure fps and performance"
HOMEPAGE = "https://github.com/RidgeRun/gst-perf-autotools"
SECTION = "multimedia"
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = "file://COPYING;md5=916f4c31aaa35d6b867dae9a7f54270d"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base gstreamer1.0-plugins-bad"

SRCBRANCH ?= "master"
SRCREV = "939eee167c6e95ed1c2f2013246b1f0b671a378b"
SRC_URI = "git://github.com/RidgeRun/gst-perf.git;protocol=https;branch=${SRCBRANCH}"

S = "${WORKDIR}/git"

INSANE_SKIP_${PN} = "dev-so"
FILES_${PN} += "${libdir}/gstreamer-1.0/libgstperf.so \
                ${libdir}/gstreamer-1.0/libgstperf.so.0 \
                ${libdir}/gstreamer-1.0/libgstperf.so.0.0.0 \
                #${libdir}/gstreamer-1.0/libgstperf.a \
		"
inherit autotools pkgconfig gettext

do_configure() {
  ${S}/autogen.sh
  oe_runconf
}

do_install_append() {
  #To avoid error related to installed but not shipped libgstperf.a
  rm -f ${D}/usr/lib/gstreamer-1.0/libgstperf.a
}
