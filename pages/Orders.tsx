import React, { useState, useEffect } from 'react';
import { Title, Text, Button, Container, Table } from '@mantine/core';
import classes from './Test.module.css';
import { HeaderMegaMenu } from '../components/HeaderMegaMenu/HeaderMegaMenu';
import { showNotification } from '@mantine/notifications';

export function OrderManager() {
  const [orders, setOrders] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');

  useEffect(() => {
    fetchOrders();
  }, []);

  const fetchOrders = async () => {
    try {
      const response = await fetch('http://localhost:8080/orders/getAll');
      if (!response.ok) throw new Error('Failed to fetch orders');
      const data = await response.json();
      setOrders(data);
    } catch (error) {
      setError(error.message);
    } finally {
      setLoading(false);
    }
  };

  const deleteOrder = async (id) => {
    try {
      const response = await fetch(`http://localhost:8080/orders/deleteById?id=${id}`, { method: 'DELETE' });
      if (!response.ok) throw new Error('Failed to delete order');
      showNotification({ title: 'Success', message: 'Order deleted successfully', color: 'green' });
      fetchOrders(); // Refresh the list
    } catch (error) {
      showNotification({ title: 'Error', message: error.message, color: 'red' });
    }
  };

  if (loading) return <p>Loading...</p>;
  if (error) return <p>Error: {error}</p>;

  return (
    <>
      <Container>
      <Title className={classes.title} ta="center" mt={100}>
        Pharma{' '}
        <Text inherit variant="gradient" component="span" gradient={{ from: 'pink', to: 'yellow' }}>
          Me
        </Text>
      </Title>
      <HeaderMegaMenu />
        <Table striped highlightOnHover>
          <thead>
            <tr>
              <th>ID</th>
              <th>User ID</th>
              <th>Total</th>
              <th>Status</th>
              <th>Actions</th>
            </tr>
          </thead>
          <tbody>
            {orders.map((order) => (
              <tr key={order.id}>
                <td>{order.id}</td>
                <td>{order.userId}</td>
                <td>${order.totalAmount}</td>
                <td>{order.status}</td>
                <td>
                  <Button color="red" onClick={() => deleteOrder(order.id)}>Delete</Button>
                </td>
              </tr>
            ))}
          </tbody>
        </Table>
      </Container>
    </>
  );
}

export default OrderManager;
