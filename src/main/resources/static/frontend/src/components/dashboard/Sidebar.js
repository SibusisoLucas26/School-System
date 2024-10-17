// src/components/Sidebar.js

import React from 'react';
import { Drawer, List, ListItem, ListItemIcon, ListItemText } from '@mui/material';
import { Dashboard, Person, Class, BarChart, Notifications, Settings } from '@mui/icons-material';
import { Link } from 'react-router-dom';

const Sidebar = () => {
  const menuItems = [
    { text: 'Dashboard', icon: <Dashboard />, path: '/dashboard' },
    { text: 'Profile', icon: <Person />, path: '/dashboard/profile' },
    { text: 'Classes', icon: <Class />, path: '/dashboard/classes' },
    { text: 'Performance', icon: <BarChart />, path: '/dashboard/performance' },
    { text: 'Notifications', icon: <Notifications />, path: '/dashboard/notifications' },
    { text: 'Settings', icon: <Settings />, path: '/dashboard/settings' },
  ];

  return (
    <Drawer variant="permanent" anchor="left">
      <List>
        {menuItems.map((item, index) => (
          <ListItem button component={Link} to={item.path} key={index}>
            <ListItemIcon>{item.icon}</ListItemIcon>
            <ListItemText primary={item.text} />
          </ListItem>
        ))}
      </List>
    </Drawer>
  );
};

export default Sidebar;
