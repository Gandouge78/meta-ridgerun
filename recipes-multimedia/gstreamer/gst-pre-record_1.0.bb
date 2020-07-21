SUMMARY = "Pre-Record"
DESCRIPTION = "GStreamer element that pre-records data continuously into a FIFO"
HOMEPAGE = "https://developer.ridgerun.com/wiki/index.php?title=GStreamer_pre-record_element"
SECTION = "multimedia"
LICENSE = "Proprietary"

LIC_FILES_CHKSUM = "file://COPYING;md5=1887e8dfc90a84423fd31d1d45ee6718"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base libffi"

#SRCBRANCH ?= "master"
#SRCREV = "1266ef3c85335f4d8a4a2af072b0a440d29bb413"
#SRC_URI = " git://git@github.com:RidgeRun/gst-prerecord.git;protocol=ssh;branch=${SRCBRANCH}"

SRC_URI = "file://gst-pre-record.tar.gz"

S = "${WORKDIR}/gst-pre-record"

FILES_${PN} += "/usr/lib/gstreamer-1.0/libgstprerecord.so"

FILES_${PN} += "\
        ${libdir}/gstreamer-1.0/libgstpretrigger.so \
        ${libdir}/gstreamer-1.0/libgstpretrigger.la \
"

inherit autotools pkgconfig gettext
