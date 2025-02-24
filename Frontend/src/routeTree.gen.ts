/* eslint-disable */

// @ts-nocheck

// noinspection JSUnusedGlobalSymbols

// This file was automatically generated by TanStack Router.
// You should NOT make any changes in this file as it will be overwritten.
// Additionally, you should also exclude this file from your linter and/or formatter to prevent it from being checked or modified.

// Import Routes

import { Route as rootRoute } from './routes/__root'
import { Route as LoginImport } from './routes/login'
import { Route as AuthImport } from './routes/_auth'
import { Route as AuthVolunteerindexImport } from './routes/_auth/volunteer_index'
import { Route as AuthVictimindexImport } from './routes/_auth/victim_index'
import { Route as AuthDonatorindexImport } from './routes/_auth/donator_index'
import { Route as AuthCharityindexImport } from './routes/_auth/charity_index'
import { Route as AuthIndexImport } from './routes/_auth/index'
import { Route as AuthUnauthorizedImport } from './routes/_auth/unauthorized'
import { Route as AuthManageresourcesImport } from './routes/_auth/manage_resources'
import { Route as AuthManagereportImport } from './routes/_auth/manage_report'
import { Route as AuthDonationsImport } from './routes/_auth/donations'
import { Route as AuthChatImport } from './routes/_auth/chat'
import { Route as AuthAddresourcesImport } from './routes/_auth/add_resources'
import { Route as AuthAddreportImport } from './routes/_auth/add_report'
import { Route as AuthAccountImport } from './routes/_auth/account'

// Create/Update Routes

const LoginRoute = LoginImport.update({
  id: '/login',
  path: '/login',
  getParentRoute: () => rootRoute,
} as any)

const AuthRoute = AuthImport.update({
  id: '/_auth',
  getParentRoute: () => rootRoute,
} as any)

const AuthVolunteerindexRoute = AuthVolunteerindexImport.update({
  id: '/volunteer_index',
  path: '/volunteer_index',
  getParentRoute: () => AuthRoute,
} as any)

const AuthVictimindexRoute = AuthVictimindexImport.update({
  id: '/victim_index',
  path: '/victim_index',
  getParentRoute: () => AuthRoute,
} as any)

const AuthDonatorindexRoute = AuthDonatorindexImport.update({
  id: '/donator_index',
  path: '/donator_index',
  getParentRoute: () => AuthRoute,
} as any)

const AuthCharityindexRoute = AuthCharityindexImport.update({
  id: '/charity_index',
  path: '/charity_index',
  getParentRoute: () => AuthRoute,
} as any)

const AuthIndexRoute = AuthIndexImport.update({
  id: '/',
  path: '/',
  getParentRoute: () => AuthRoute,
} as any)

const AuthUnauthorizedRoute = AuthUnauthorizedImport.update({
  id: '/unauthorized',
  path: '/unauthorized',
  getParentRoute: () => AuthRoute,
} as any)

const AuthManageresourcesRoute = AuthManageresourcesImport.update({
  id: '/manage_resources',
  path: '/manage_resources',
  getParentRoute: () => AuthRoute,
} as any)

const AuthManagereportRoute = AuthManagereportImport.update({
  id: '/manage_report',
  path: '/manage_report',
  getParentRoute: () => AuthRoute,
} as any)

const AuthDonationsRoute = AuthDonationsImport.update({
  id: '/donations',
  path: '/donations',
  getParentRoute: () => AuthRoute,
} as any)

const AuthChatRoute = AuthChatImport.update({
  id: '/chat',
  path: '/chat',
  getParentRoute: () => AuthRoute,
} as any)

const AuthAddresourcesRoute = AuthAddresourcesImport.update({
  id: '/add_resources',
  path: '/add_resources',
  getParentRoute: () => AuthRoute,
} as any)

const AuthAddreportRoute = AuthAddreportImport.update({
  id: '/add_report',
  path: '/add_report',
  getParentRoute: () => AuthRoute,
} as any)

const AuthAccountRoute = AuthAccountImport.update({
  id: '/account',
  path: '/account',
  getParentRoute: () => AuthRoute,
} as any)

// Populate the FileRoutesByPath interface

declare module '@tanstack/react-router' {
  interface FileRoutesByPath {
    '/_auth': {
      id: '/_auth'
      path: ''
      fullPath: ''
      preLoaderRoute: typeof AuthImport
      parentRoute: typeof rootRoute
    }
    '/login': {
      id: '/login'
      path: '/login'
      fullPath: '/login'
      preLoaderRoute: typeof LoginImport
      parentRoute: typeof rootRoute
    }
    '/_auth/account': {
      id: '/_auth/account'
      path: '/account'
      fullPath: '/account'
      preLoaderRoute: typeof AuthAccountImport
      parentRoute: typeof AuthImport
    }
    '/_auth/add_report': {
      id: '/_auth/add_report'
      path: '/add_report'
      fullPath: '/add_report'
      preLoaderRoute: typeof AuthAddreportImport
      parentRoute: typeof AuthImport
    }
    '/_auth/add_resources': {
      id: '/_auth/add_resources'
      path: '/add_resources'
      fullPath: '/add_resources'
      preLoaderRoute: typeof AuthAddresourcesImport
      parentRoute: typeof AuthImport
    }
    '/_auth/charity_index': {
      id: '/_auth/charity_index'
      path: '/charity_index'
      fullPath: '/charity_index'
      preLoaderRoute: typeof AuthCharityindexImport
      parentRoute: typeof AuthImport
    }
    '/_auth/chat': {
      id: '/_auth/chat'
      path: '/chat'
      fullPath: '/chat'
      preLoaderRoute: typeof AuthChatImport
      parentRoute: typeof AuthImport
    }
    '/_auth/donations': {
      id: '/_auth/donations'
      path: '/donations'
      fullPath: '/donations'
      preLoaderRoute: typeof AuthDonationsImport
      parentRoute: typeof AuthImport
    }
    '/_auth/donator_index': {
      id: '/_auth/donator_index'
      path: '/donator_index'
      fullPath: '/donator_index'
      preLoaderRoute: typeof AuthDonatorindexImport
      parentRoute: typeof AuthImport
    }
    '/_auth/manage_report': {
      id: '/_auth/manage_report'
      path: '/manage_report'
      fullPath: '/manage_report'
      preLoaderRoute: typeof AuthManagereportImport
      parentRoute: typeof AuthImport
    }
    '/_auth/manage_resources': {
      id: '/_auth/manage_resources'
      path: '/manage_resources'
      fullPath: '/manage_resources'
      preLoaderRoute: typeof AuthManageresourcesImport
      parentRoute: typeof AuthImport
    }
    '/_auth/unauthorized': {
      id: '/_auth/unauthorized'
      path: '/unauthorized'
      fullPath: '/unauthorized'
      preLoaderRoute: typeof AuthUnauthorizedImport
      parentRoute: typeof AuthImport
    }
    '/_auth/victim_index': {
      id: '/_auth/victim_index'
      path: '/victim_index'
      fullPath: '/victim_index'
      preLoaderRoute: typeof AuthVictimindexImport
      parentRoute: typeof AuthImport
    }
    '/_auth/volunteer_index': {
      id: '/_auth/volunteer_index'
      path: '/volunteer_index'
      fullPath: '/volunteer_index'
      preLoaderRoute: typeof AuthVolunteerindexImport
      parentRoute: typeof AuthImport
    }
    '/_auth/': {
      id: '/_auth/'
      path: '/'
      fullPath: '/'
      preLoaderRoute: typeof AuthIndexImport
      parentRoute: typeof AuthImport
    }
  }
}

// Create and export the route tree

interface AuthRouteChildren {
  AuthAccountRoute: typeof AuthAccountRoute
  AuthAddreportRoute: typeof AuthAddreportRoute
  AuthAddresourcesRoute: typeof AuthAddresourcesRoute
  AuthCharityindexRoute: typeof AuthCharityindexRoute
  AuthChatRoute: typeof AuthChatRoute
  AuthDonationsRoute: typeof AuthDonationsRoute
  AuthDonatorindexRoute: typeof AuthDonatorindexRoute
  AuthManagereportRoute: typeof AuthManagereportRoute
  AuthManageresourcesRoute: typeof AuthManageresourcesRoute
  AuthUnauthorizedRoute: typeof AuthUnauthorizedRoute
  AuthVictimindexRoute: typeof AuthVictimindexRoute
  AuthVolunteerindexRoute: typeof AuthVolunteerindexRoute
  AuthIndexRoute: typeof AuthIndexRoute
}

const AuthRouteChildren: AuthRouteChildren = {
  AuthAccountRoute: AuthAccountRoute,
  AuthAddreportRoute: AuthAddreportRoute,
  AuthAddresourcesRoute: AuthAddresourcesRoute,
  AuthCharityindexRoute: AuthCharityindexRoute,
  AuthChatRoute: AuthChatRoute,
  AuthDonationsRoute: AuthDonationsRoute,
  AuthDonatorindexRoute: AuthDonatorindexRoute,
  AuthManagereportRoute: AuthManagereportRoute,
  AuthManageresourcesRoute: AuthManageresourcesRoute,
  AuthUnauthorizedRoute: AuthUnauthorizedRoute,
  AuthVictimindexRoute: AuthVictimindexRoute,
  AuthVolunteerindexRoute: AuthVolunteerindexRoute,
  AuthIndexRoute: AuthIndexRoute,
}

const AuthRouteWithChildren = AuthRoute._addFileChildren(AuthRouteChildren)

export interface FileRoutesByFullPath {
  '': typeof AuthRouteWithChildren
  '/login': typeof LoginRoute
  '/account': typeof AuthAccountRoute
  '/add_report': typeof AuthAddreportRoute
  '/add_resources': typeof AuthAddresourcesRoute
  '/charity_index': typeof AuthCharityindexRoute
  '/chat': typeof AuthChatRoute
  '/donations': typeof AuthDonationsRoute
  '/donator_index': typeof AuthDonatorindexRoute
  '/manage_report': typeof AuthManagereportRoute
  '/manage_resources': typeof AuthManageresourcesRoute
  '/unauthorized': typeof AuthUnauthorizedRoute
  '/victim_index': typeof AuthVictimindexRoute
  '/volunteer_index': typeof AuthVolunteerindexRoute
  '/': typeof AuthIndexRoute
}

export interface FileRoutesByTo {
  '/login': typeof LoginRoute
  '/account': typeof AuthAccountRoute
  '/add_report': typeof AuthAddreportRoute
  '/add_resources': typeof AuthAddresourcesRoute
  '/charity_index': typeof AuthCharityindexRoute
  '/chat': typeof AuthChatRoute
  '/donations': typeof AuthDonationsRoute
  '/donator_index': typeof AuthDonatorindexRoute
  '/manage_report': typeof AuthManagereportRoute
  '/manage_resources': typeof AuthManageresourcesRoute
  '/unauthorized': typeof AuthUnauthorizedRoute
  '/victim_index': typeof AuthVictimindexRoute
  '/volunteer_index': typeof AuthVolunteerindexRoute
  '/': typeof AuthIndexRoute
}

export interface FileRoutesById {
  __root__: typeof rootRoute
  '/_auth': typeof AuthRouteWithChildren
  '/login': typeof LoginRoute
  '/_auth/account': typeof AuthAccountRoute
  '/_auth/add_report': typeof AuthAddreportRoute
  '/_auth/add_resources': typeof AuthAddresourcesRoute
  '/_auth/charity_index': typeof AuthCharityindexRoute
  '/_auth/chat': typeof AuthChatRoute
  '/_auth/donations': typeof AuthDonationsRoute
  '/_auth/donator_index': typeof AuthDonatorindexRoute
  '/_auth/manage_report': typeof AuthManagereportRoute
  '/_auth/manage_resources': typeof AuthManageresourcesRoute
  '/_auth/unauthorized': typeof AuthUnauthorizedRoute
  '/_auth/victim_index': typeof AuthVictimindexRoute
  '/_auth/volunteer_index': typeof AuthVolunteerindexRoute
  '/_auth/': typeof AuthIndexRoute
}

export interface FileRouteTypes {
  fileRoutesByFullPath: FileRoutesByFullPath
  fullPaths:
    | ''
    | '/login'
    | '/account'
    | '/add_report'
    | '/add_resources'
    | '/charity_index'
    | '/chat'
    | '/donations'
    | '/donator_index'
    | '/manage_report'
    | '/manage_resources'
    | '/unauthorized'
    | '/victim_index'
    | '/volunteer_index'
    | '/'
  fileRoutesByTo: FileRoutesByTo
  to:
    | '/login'
    | '/account'
    | '/add_report'
    | '/add_resources'
    | '/charity_index'
    | '/chat'
    | '/donations'
    | '/donator_index'
    | '/manage_report'
    | '/manage_resources'
    | '/unauthorized'
    | '/victim_index'
    | '/volunteer_index'
    | '/'
  id:
    | '__root__'
    | '/_auth'
    | '/login'
    | '/_auth/account'
    | '/_auth/add_report'
    | '/_auth/add_resources'
    | '/_auth/charity_index'
    | '/_auth/chat'
    | '/_auth/donations'
    | '/_auth/donator_index'
    | '/_auth/manage_report'
    | '/_auth/manage_resources'
    | '/_auth/unauthorized'
    | '/_auth/victim_index'
    | '/_auth/volunteer_index'
    | '/_auth/'
  fileRoutesById: FileRoutesById
}

export interface RootRouteChildren {
  AuthRoute: typeof AuthRouteWithChildren
  LoginRoute: typeof LoginRoute
}

const rootRouteChildren: RootRouteChildren = {
  AuthRoute: AuthRouteWithChildren,
  LoginRoute: LoginRoute,
}

export const routeTree = rootRoute
  ._addFileChildren(rootRouteChildren)
  ._addFileTypes<FileRouteTypes>()

/* ROUTE_MANIFEST_START
{
  "routes": {
    "__root__": {
      "filePath": "__root.tsx",
      "children": [
        "/_auth",
        "/login"
      ]
    },
    "/_auth": {
      "filePath": "_auth.tsx",
      "children": [
        "/_auth/account",
        "/_auth/add_report",
        "/_auth/add_resources",
        "/_auth/charity_index",
        "/_auth/chat",
        "/_auth/donations",
        "/_auth/donator_index",
        "/_auth/manage_report",
        "/_auth/manage_resources",
        "/_auth/unauthorized",
        "/_auth/victim_index",
        "/_auth/volunteer_index",
        "/_auth/"
      ]
    },
    "/login": {
      "filePath": "login.tsx"
    },
    "/_auth/account": {
      "filePath": "_auth/account.tsx",
      "parent": "/_auth"
    },
    "/_auth/add_report": {
      "filePath": "_auth/add_report.tsx",
      "parent": "/_auth"
    },
    "/_auth/add_resources": {
      "filePath": "_auth/add_resources.tsx",
      "parent": "/_auth"
    },
    "/_auth/charity_index": {
      "filePath": "_auth/charity_index.tsx",
      "parent": "/_auth"
    },
    "/_auth/chat": {
      "filePath": "_auth/chat.tsx",
      "parent": "/_auth"
    },
    "/_auth/donations": {
      "filePath": "_auth/donations.tsx",
      "parent": "/_auth"
    },
    "/_auth/donator_index": {
      "filePath": "_auth/donator_index.tsx",
      "parent": "/_auth"
    },
    "/_auth/manage_report": {
      "filePath": "_auth/manage_report.tsx",
      "parent": "/_auth"
    },
    "/_auth/manage_resources": {
      "filePath": "_auth/manage_resources.tsx",
      "parent": "/_auth"
    },
    "/_auth/unauthorized": {
      "filePath": "_auth/unauthorized.tsx",
      "parent": "/_auth"
    },
    "/_auth/victim_index": {
      "filePath": "_auth/victim_index.tsx",
      "parent": "/_auth"
    },
    "/_auth/volunteer_index": {
      "filePath": "_auth/volunteer_index.tsx",
      "parent": "/_auth"
    },
    "/_auth/": {
      "filePath": "_auth/index.tsx",
      "parent": "/_auth"
    }
  }
}
ROUTE_MANIFEST_END */
