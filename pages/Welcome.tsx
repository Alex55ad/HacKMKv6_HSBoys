import { Title, Text, Anchor } from '@mantine/core';
import classes from './Welcome.module.css';
import { HeaderMegaMenu } from '../components/HeaderMegaMenu/HeaderMegaMenu';
import { NavbarNested } from '../components/NavbarNested/NavbarNested';
import { TableReviews } from '../components/TableReviews/TableReviews';


export function Welcome() {
  return (
    <>
      <Title className={classes.title} ta="center" mt={100}>
        Pharma{' '}
        <Text inherit variant="gradient" component="span" gradient={{ from: 'pink', to: 'yellow' }}>
          Me
        </Text>
      </Title>
      <HeaderMegaMenu />
      <NavbarNested/>
      <Text color="dimmed" ta="center" size="lg" maw={580} mx="auto" mt="xl">
       {' '}
        <Anchor href="https://mantine.dev/guides/next/" size="lg">
 
        </Anchor>
      </Text>
    </>
  );
}

export default Welcome;
