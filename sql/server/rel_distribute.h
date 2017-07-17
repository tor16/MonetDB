/*
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0.  If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 *
 * Copyright 1997 - July 2008 CWI, August 2008 - 2017 MonetDB B.V.
 */

#ifndef _REL_DISTRIBUTE_H_
#define _REL_DISTRIBUTE_H_

#include "sql_relation.h"
#include "sql_mvc.h"

extern sql_rel * rel_distribute(mvc *sql, sql_rel *rel);

#endif /*_REL_DISTRIBUTE_H_*/
